import styles from "./SearchList.module.css";

import { useEffect, useState } from "react";
import { useRouter } from "next/router";

import axios from "axios";
import cookie from "react-cookies";
import { Keyword } from "@/src/interfaces/Keyword";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "@/src/store/store";
import SearchItem from "./SearchItem";
import Pagebar from "../Pagenation/Pagebar";
import { setSearchPlace } from "@/src/store/reducers/searchPlaceSlice";
import { setPage } from "@/src/store/reducers/pageSlice";
import ListContainer from "../UI/ListContainer";
// import PlaceItem from "../Place/PlaceItem";

export default function SearchPlaceList(): JSX.Element {
  const [searchResult, setSearchResult] = useState<Keyword[]>([]);
  const router = useRouter();
  const { keyword } = router.query;
  const dispatch = useDispatch();
  const page = useSelector((state: RootState) => state.page.page);
  const totalPages: number = useSelector(
    (state: RootState) => state.searchPlace.totalPages
  );
  const accessToken = cookie.load("accessToken");

  useEffect(() => {
    const fetchKeyword = async () => {
      try {
        const headers: { [key: string]: string } = {};
        if (accessToken) {
          headers["Access-Token"] = accessToken;
          headers.withCredentials = "true";
        }

        const res = await axios.get(
          `${process.env.NEXT_PUBLIC_API_URL}/api/place`,
          {
            params: {
              keyword: keyword,
              page: page,
            },
            headers: headers,
          }
        );
        if (res.data.data.content !== []) {
          dispatch(setSearchPlace(res.data.data));
          setPage(totalPages);
          const { content } = res.data.data;
          setSearchResult(content);
          console.log(content);
        } else {
          console.log(res.data);
        }
      } catch (error) {
        console.log("Error", error);
      }
    };
    if (keyword) {
      fetchKeyword();
    }
  }, [keyword, page, accessToken]);

  return (
    <>
      <section className={styles.section}>
        <h3 className={styles.h3}>검색하신 결과: {keyword} </h3>
        <ul className={styles.keywordList}>
          {searchResult.length > 0 ? (
            <ListContainer>
              {searchResult?.map((place) => (
                <SearchItem
                  key={place.placeId}
                  name={place.name}
                  firstImage={place.firstImage}
                  contentId={place.contentId}
                  placeId={place.placeId}
                  isBookmarked={place.isBookmarked}
                  averageRating={place.averageRating}
                  reviewTotalElements={place.reviewTotalElements}
                />
              ))}
            </ListContainer>
          ) : (
            <div className={styles.div}>
              <p className={styles.noResult}>
                해당하는 검색 결과가 없습니다. 😢
              </p>
            </div>
          )}
        </ul>
        <Pagebar totalPage={totalPages} />
      </section>
    </>
  );
}
