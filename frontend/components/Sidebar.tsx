import Link from "next/link";
import styled from "styled-components";

const SidebarWrapper = styled.div`
  position: fixed;
  top: 15%;
  left: 1%;
  bottom: 15%;
  width: 240px;
  background-color: #e5e5e5;
`;

const List = styled.li`
  list-style-type: none;
  list-style: none;
`;

const Button = styled.button`
  display: block;
  width: 100%;
  padding: 12px 16px;
  background-color: transparent;
  border: none;
  font-size: 16px;
  font-weight: bold;
  color: #333;

  &:hover {
    background-color: #ddd;
  }
`;

const Sidebar = () => {
  return (
    <SidebarWrapper>
      <ul>
        <List>
          <Link href="/user" style={{ textDecoration: "none" }}>
            <Button>회원정보</Button>
          </Link>
        </List>
        <List>
          <Link href="/user/edit" style={{ textDecoration: "none" }}>
            <Button>회원정보 수정</Button>
          </Link>
        </List>
        <List>
          <Link href="/favorites" style={{ textDecoration: "none" }}>
            <Button>즐겨찾기</Button>
          </Link>
        </List>
        <List>
          <Link href="/trips" style={{ textDecoration: "none" }}>
            <Button>나의 여행 일정</Button>
          </Link>
        </List>
        <List>
          <Link href="/comments" style={{ textDecoration: "none" }}>
            <Button>내가 쓴 댓글</Button>
          </Link>
        </List>
        <List>
          <Link href="/posts" style={{ textDecoration: "none" }}>
            <Button>내가 쓴 게시글</Button>
          </Link>
        </List>
        <List>
          <Link href="/activity" style={{ textDecoration: "none" }}>
            <Button>내 활동 알림</Button>
          </Link>
        </List>
        <List>
          <Link href="/requests" style={{ textDecoration: "none" }}>
            <Button>요청한 장소</Button>
          </Link>
        </List>
      </ul>
    </SidebarWrapper>
  );
};

export default Sidebar;
