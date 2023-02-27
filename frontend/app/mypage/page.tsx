"use client";
import Button from "@/components/Button/Button";
import Sidebar from "@/components/Sidebar";
import React from "react";
import styled from "styled-components";

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  height: 100%;
`;

const Title = styled.h1`
  text-align: center;
  margin-bottom: 3rem;
  margin-top: 3rem;
`;

const ProfileWrapper = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-bottom: 1.5rem;
`;

const Avatar = styled.div`
  width: 120px;
  height: 120px;
  border-radius: 50%;
  background-color: #e5e5e5;
  margin-right: 1rem;
`;

const Name = styled.h1`
  font-size: 2rem;
  margin-bottom: 0.5rem;
`;

const Nickname = styled.h2`
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
`;

const Email = styled.p`
  font-size: 1rem;
  margin-bottom: 1rem;
`;

const ButtonWrapper = styled.div`
  display: flex;
  gap: 1rem;
  margin-top: 2rem;
`;

const MyPage: React.FC = () => {
  return (
    <Container>
      <Title>마이페이지</Title>
      <Sidebar />
      <ProfileWrapper>
        <Avatar />
        <div>
          <Name>김 모행</Name>
          <Nickname>모행이</Nickname>
          <Email>mohaeng@example.com</Email>
        </div>
      </ProfileWrapper>
      <ButtonWrapper>
        <Button text="정보수정" />
        <Button text="회원탈퇴" />
      </ButtonWrapper>
    </Container>
  );
};

export default MyPage;
