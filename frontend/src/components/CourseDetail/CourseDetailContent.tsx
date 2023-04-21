import { useAppSelector } from "@/src/hooks/useReduxHooks";
import { useRouter } from "next/router";
import React from "react";
import KakaoMap from "../KakaoMap/KakaoMap";
import TagItem from "../UI/TagItem";

import styles from "./CourseDetailContent.module.css";
import CourseOrderList from "./CourseOrderList";

const CourseDetailContent = () => {
  const handleClick = () => {};
  const courseDetail = useAppSelector((state) => state.courseDetail.course);
  const { content, startDate, endDate, region, places } = courseDetail;

  return (
    <div className={styles["content-container"]}>
      <p className={styles.content}>{content}</p>
      <div className={styles.info}>
        {places && places.length > 0 && <KakaoMap mapData={places} />}
        {places && places.length > 0 && <CourseOrderList places={places} />}
      </div>
    </div>
  );
};

export default CourseDetailContent;
