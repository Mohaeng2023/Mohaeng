import styles from "./CourseDetailNav.module.css";
import { useState } from "react";
import RoughMap from "../Course/RoughMap";
import {
  BsBookmark,
  BsBookmarkFill,
  BsMapFill,
  BsMap,
  BsShare,
} from "react-icons/bs";
import { useAppDispatch, useAppSelector } from "@/src/hooks/useReduxHooks";
import {
  detailBookmarkToggleAction,
  detailLikeToggleAction,
} from "@/src/store/reducers/courseDetailSlice";
import { openModal } from "@/src/store/reducers/modalSlice";
import TagItem from "../UI/TagItem";
import { kakaoShare } from "@/src/utils/kakao-share";
import LIkeButton from "../UI/LIkeButton";

const CourseDetailNav = () => {
  const [isRoughMapOpen, setIsRoughMapOpen] = useState(false);

  const dispatch = useAppDispatch();
  const { id: userId } = useAppSelector((state) => state.token);
  const course = useAppSelector((state) => state.courseDetail.course);
  const {
    title,
    content,
    likeCount,
    places,
    courseId,
    isBookmarked,
    isLiked,
    startDate,
    endDate,
    region,
  } = course;

  const toggleRoughMapHandler = (e: React.MouseEvent<HTMLDivElement>): void => {
    e.stopPropagation();
    setIsRoughMapOpen((prev) => !prev);
  };
  const onClose = () => {
    setIsRoughMapOpen(false);
  };

  const bookmarkHandler = (id: number) => {
    if (userId) {
      dispatch(detailBookmarkToggleAction(id));
    } else {
      dispatch(
        openModal({
          modalType: "LoginModal",
          isOpen: true,
        })
      );
    }
  };

  const handleDetailLike = () => {
    if (userId) {
      dispatch(detailLikeToggleAction(courseId));
    } else {
      dispatch(
        openModal({
          modalType: "LoginModal",
          isOpen: true,
        })
      );
    }
  };

  const handleKakaoShare = () => {
    if (userId) {
      const param = {
        title,
        content,
        thumbnailUrl: places[0].imgUrl,
        likeCount,
        courseId,
      };
      kakaoShare(param);
    } else {
      dispatch(
        openModal({
          modalType: "LoginModal",
          isOpen: true,
        })
      );
    }
  };

  const RoughMapData = places?.map((place) => place.name).join(",");

  return (
    <div className={styles["title-nav"]}>
      <div className={styles["simple-info"]}>
        <div className={styles.date}>
          <TagItem size="S" text="기간" bgColor="Dsky" />
          <p className={styles.text}>
            {startDate} ~ {endDate}
          </p>
        </div>
        <div className={styles.region}>
          <TagItem size="S" text="지역" bgColor="LMarinBlue" />
          <p className={styles.text}>{region}</p>
        </div>
      </div>
      <div className={styles["detail-nav"]}>
        <LIkeButton
          isLiked={isLiked}
          likeCount={likeCount}
          onClick={handleDetailLike}
        />
        <div
          className={`${styles["item-nav"]} ${styles.roughmapBtn}`}
          onClick={toggleRoughMapHandler}
        >
          {isRoughMapOpen ? (
            <BsMapFill className={styles.icon} color="var(--color-blue)" />
          ) : (
            <BsMap className={styles.icon} />
          )}
          {isRoughMapOpen && (
            <RoughMap RoughMapData={RoughMapData} onClose={onClose} />
          )}
        </div>
        <div
          className={styles["item-nav"]}
          onClick={() => bookmarkHandler(courseId)}
        >
          {isBookmarked ? (
            <BsBookmarkFill className={`${styles.bookmark} ${styles.icon}`} />
          ) : (
            <BsBookmark className={`${styles.unbookmark} ${styles.icon}`} />
          )}
        </div>
        <div className={styles["item-nav"]} onClick={handleKakaoShare}>
          <BsShare className={styles.icon} />
        </div>
      </div>
    </div>
  );
};

export default CourseDetailNav;
