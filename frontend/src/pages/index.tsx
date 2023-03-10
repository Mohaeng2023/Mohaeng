import styles from "./index.module.css";
import RecommendedSection from "../components/Main/RecommendedSection";
import PlaceCardSlider from "../components/Main/PlaceCardSlider";
import CourseCardSlider from "../components/Main/CourseCardSlider";
import BannerSearch from "../components/Main/BannerSearch";
import AccompanyBoard from "../components/Main/AccompanyBoard";
import BoardFilters from "../components/Main/BoardFilters";

export default function Home() {
  return (
    <>
      <main className={styles.main}>
        <BannerSearch />
        <div className={styles["home-body-container"]}>
          <div className={styles["home-content-container"]}>
            <RecommendedSection
              title="π₯λ³μ  Top 5 μ¬νμ§"
              bgColor="grey"
              linkUrl="place"
            >
              <PlaceCardSlider />
            </RecommendedSection>
            <RecommendedSection
              title="β€οΈμΆμ² μ½μ€"
              bgColor="grey"
              linkUrl="course"
            >
              <CourseCardSlider />
            </RecommendedSection>
            <RecommendedSection
              title="π§βπ€βπ§λν κ²μν"
              bgColor="grey"
              linkUrl="accompany"
            >
              <BoardFilters />
              <AccompanyBoard />
            </RecommendedSection>
          </div>
        </div>
      </main>
    </>
  );
}
