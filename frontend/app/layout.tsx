"use client";

import "../styles/globals.css";
import Header from "@/components/Header/Header";
import { Provider } from "react-redux";
import store from "@/store/store";
import GlobalModal from "@/components/Modal/GlobalModal";
import Footer from "@/components/Footer/Footer";

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="ko">
      <head />
      <body>
        <Provider store={store}>
          <GlobalModal />
          <Header />
          <div className="wrapper">
            <div className="contentWrapper">{children}</div>
            <Footer />
          </div>
        </Provider>
      </body>
    </html>
  );
}
