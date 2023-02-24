"use client";

import Sidebar from "@/components/Sidebar";
import React from "react";
import styled from "styled-components";

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100%;
`;

const Title = styled.h1`
  text-align: center;
`;

const Text = styled.p`
  text-align: center;
`;

const MyPage: React.FC = () => {
  return (
    <Container>
      <Title>마이페이지</Title>
      <Sidebar />
      <Text>여행 커뮤니티의 마이페이지입니다.</Text>
    </Container>
  );
};

export default MyPage;
