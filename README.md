# 사용자가 만드는 국내여행 플랫폼, 모두의 여행 Mohaeng

![image](https://user-images.githubusercontent.com/94662639/232202485-4d2b4605-312a-406b-be3c-e396dd0f8972.png)

모두의 여행은 국내 여행 커뮤니티 플랫폼입니다

국내의 다양한 여행지를 검색하여 직접 여행 코스를 작성할 수 있고, 해당 일정을 다른 사용자들과 공유하며 국내 여행을 보다 더 편리하고 즐겁게 할 수 있는 서비스를 목표로 진행한 프로젝트입니다

## 📝 관련 링크


[Github](https://github.com/Mohaeng2023/Mohaeng)

[요구사항 및 기능정의서](https://docs.google.com/spreadsheets/d/1s9AVLdhSfp5DTqd-lz0jkD7A-DtikWaR5JPT4BtyXx8/edit#gid=0)

[API 문서](https://www.notion.so/API-ccec3cd5f7614c30b3f0c4d43d7e4a5c)

## 📌 프로젝트 소개

- **프로젝트 배경** : 사용자 경험에 초점을 맞춘 국내 여행 웹사이트의 필요성
- **프로젝트 목표** : 직접 일정을 작성하고 유저들과 공유하며 국내 여행을 보다 더 편리하고 즐겁게 할 수 있는 경험을 제공하자
- **개발기간** : 2023/02/01 ~ 2023/04/09 (약 2달)
- **인원** : 6명(FE 3명, BE 3명)

## 📙 기획 의도

![image](https://user-images.githubusercontent.com/77098586/235631768-53d71059-5710-4fcd-a396-95563157278f.png)

## 💚💻 프론트엔드 기술 스택

![image](https://user-images.githubusercontent.com/77098586/235633179-c5a5d4b8-6e58-4ec7-bb03-b934bc8f814b.png)

## 💙💻 백엔드 기술 스택

![image](https://user-images.githubusercontent.com/77098586/235633527-5128a6f3-5cc5-4ddb-81c7-d3bcdc20498a.png)

## ⚙ 인프라 기술 스택

![image](https://user-images.githubusercontent.com/77098586/235634416-3e305cae-b59c-41cb-bcac-f3f084456aa3.png)

## 💡 인프라 구조

![image](https://user-images.githubusercontent.com/77098586/236680931-15e830b3-0166-43f8-8cf7-b4909beba8c7.png)

## 📘 협업 툴

- Notion
- Github
- Git
- Figma
- erdcloud
- draw.io

## 🌐 데이터베이스 구조

![image](https://user-images.githubusercontent.com/77098586/233893698-57a595b3-5a82-46b0-b66e-9eebfe7b5df1.png)

## 💡 주요 기능


### 메인페이지

![메인](https://github.com/Mohaeng2023/Mohaeng/assets/56632443/a3f5acf2-0184-46f8-bd30-ed5d5f33294a)

- 모행에서 별점이 높고 리뷰가 많이 달린 TOP10 여행지와 좋아요가 많은 코스 목록을 슬라이더로 보여주고 아이템을 클릭하면 해당 상세 페이지로 이동한다.
- 더보기 버튼을 클릭하여 각 페이지로 이동할 수 있다.
- 코스 좋아요 토글 기능을 사용할 수 있다.

### 통합검색

![통합검색](https://github.com/Mohaeng2023/Mohaeng/assets/108039645/66f4e194-26db-4be2-a84e-e525da82d574)

- 검색창에 단어를 입력하면 해당 단어가 포함된 검색 결과를 확인할 수 있다.
- 여행지와 코스 탭을 이동하면 해당하는 여행지 목록을 페이지네이션으로 보여준다.
- 해당 여행지의 별점과 리뷰 개수, 해당 코스의 좋아요 수를 목록에서 확인할 수 있다.
- 로그인한 사용자의 북마크 여부를 확인할 수 있다.

### 여행지 목록 페이지

![여행지 전체](https://user-images.githubusercontent.com/94662639/232213110-0fdd347b-729c-43c5-b00a-2f02483a4e76.gif)

- 지역 필터를 통해 검색하고 싶은 지역의 여행지를 볼 수 있다.
- 북마크 버튼을 통해 마이페이지 즐겨찾기 메뉴에서 사용자가 북마크한 여행지를 볼 수 있다. 비로그인시 북마크 버튼을 클릭하면 로그인 페이지로 이동한다.
- 페이지 이동을 통해 특정한 여행지를 효율적으로 찾을 수 있다.

### 여행지 상세

![상세조회](https://github.com/sagesrkim/prgms-study/assets/108039645/b640d874-ace4-466a-a824-6e7f576191bc)

- 여행 상세정보
  - 해당 여행지의 사진과 세부정보를 확인할 수 있다. 여행지의 장소는 카카오 맵으로 표시한다.
  - 북마크 버튼을 클릭하면 마이페이지에서 저장된 북마크 목록을 볼 수 있다. 로그인하지 않은 사용자가 북마크 클릭 시 로그인 페이지로 이동한다.
- 리뷰 목록
  - 평균 별점과 총 리뷰의 개수를 확인하고 리뷰 목록을 페이지네이션으로 조회할 수 있다. 
  - 정렬을 통해 최신순, 별점 높은 순으로 리뷰 목록을 정렬할 수 있다.
  - 로그인하지 않은 사용자가 리뷰 작성 버튼을 누르면 로그인 페이지로 이동한다.
  - 해당 리뷰에서 더보기 버튼을 클릭하면 상세한 글과 첨부된 사진을 같이 확인할 수 있다.

### 여행지 리뷰 작성

![여행지 리뷰](https://user-images.githubusercontent.com/108039645/232230248-10f4057a-41a2-4b31-930d-48939e2466ab.gif)

- 마우스 이동에 따라 별점을 활성화할 수 있고 클릭하면 해당 별점의 점수를 생성할 수 있다.
- 이미지를 첨부하여 미리보기로 첨부한 사진을 확인한 후, 삭제하고 추가할 수 있다. 
- 작성한 리뷰를 토대로 수정하고 삭제할 수 있다.

### 코스 목록 페이지

![코스목록](https://github.com/Mohaeng2023/Mohaeng/assets/56632443/8e35f9db-9fdf-48a3-a9b0-4c5be392683c)

- 지역, 키워드, 좋아요 많은 순/최신순으로 사용자가 원하는 조건에 맞게 코스를 조회할 수 있다.
- 총 좋아요 수와, 좋아요 상태를 나타내는 좋아요 토글 기능 그리고 북마크 토글 기능을 사용할 수 있다.
- 약도 보기를 통해 코스에 추가된 장소들을 약도로 확인할 수 있다.
- 코스 공유하기로 카카오톡 친구에게 공유할 수 있다.
- 작성하기 버튼을 클릭하면 코스를 직접 작성할 수 있다.

### 코스 작성 페이지

- 공개/비공개, 제목, 시작일자, 종료일자, 지역, 소요일, 코스 설명에 대한 내용을 입력할 수 있다.
- 장소를 키워드로 검색하면 해당하는 장소가 나타나며 무한 스크롤 방식이다. 클릭으로 장소를 추가할 수 있다.
- 장소를 추가하면 마커와 라인이 찍힌 카카오 지도와, 방문할 장소의 순서와 장소의 정보, 추가한 장소를 제거할 수 있는 목록이 나타난다.

### 코스 수정 페이지

- 코스 작성 페이지와 동일하며, 기존 작성한 코스의 내용이 불러와지며 해당 내용을 수정할 수 있다.

### 코스 상세 페이지

![코스상세](https://github.com/Mohaeng2023/Mohaeng/assets/56632443/4c41b32b-268a-4f8f-956f-0a6908e746c8)

- 코스의 상세한 정보를 보여준다.
- 총 좋아요 수와, 좋아요 상태를 나타내는 좋아요 토글 기능 그리고 북마크 토글 기능을 사용할 수 있다.
- 약도 보기를 통해 코스에 추가된 장소들을 약도로 확인할 수 있다.
- 코스 공유하기로 카카오톡 친구에게 공유할 수 있다.
- 사용자 본인이 작성한 코스일 경우 수정, 삭제 버튼이 나타나고 코스를 수정 혹은 삭제 할 수 있다.

### 마이페이지

![마이페이지 전체](https://user-images.githubusercontent.com/94662639/232225826-ca25b0b2-6c32-4b5a-9c20-aac238b90115.gif)

- 회원정보
  - 정보 수정 버튼을 통한 프로필 사진과 닉네임 변경이 가능하다.
  - 회원 탈퇴시 탈퇴 확인 모달창이 뜨며 실수로 탈퇴하는 것을 방지한다.
- 즐겨찾기
  - 탭을 통해 여행지와 코스 북마크를 조회할 수 있다.
  - 북마크 버튼을 클릭시 즐겨찾기 목록에서 삭제된다.
  - 이미지 클릭 시 해당 북마크의 상세 페이지로 이동한다.
  - 모든 북마크 아이템은 목록 내에서 무한 스크롤 방식으로 조회할 수 있다.
- 나의 여행 일정
  - 사용자가 작성한 코스를 확인할 수 있다.
  - 해당 페이지 내부에서 사용자의 코스를 공개/비공개로 전환할 수 있다
  - 이미지를 클릭하면 코스 상세로 이동하며 해당 페이지에서 코스를 수정하고 삭제할 수 있다.
- 내가 쓴 글
  - 해당 페이지에서 사용자가 작성한 리뷰와 별점을 확인할 수 있다.
  - 이미지를 클릭하면 해당 리뷰가 있는 여행지 상세 페이지로 이동한다.
  - 모든 리뷰 아이템은 목록 내에서 무한 스크롤 방식으로 조회할 수 있다.

## ✉️ Contact

### 백엔드

- 강승구 : **krrr883@gmail.com**
- 장지혜 : **jihye219219@gmail.com**
- 홍석영 : **binaryhong@gmail.com**

### 프론트엔드

- 김새롬 : **sagesaeromkim@gmail.com**
- 김정민 : **gyflsakfn@gmail.com**
- 유은경 : **deaese94@gmail.com**
