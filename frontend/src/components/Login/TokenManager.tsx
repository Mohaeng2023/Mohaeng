import axios from "axios";
import cookie from "react-cookies";

type saveToken = {
  accessToken: string;
  refreshToken: string;
};

function saveToken(accessToken: string, refreshToken: string) {
  axios.defaults.headers.common["accessToken"] = accessToken;
  axios.defaults.headers.common["refreshToken"] = refreshToken;

  const expires = new Date();
  expires.setDate(Date.now() + 1000 * 60 * 60 * 24);

  cookie.save("accessToken", accessToken, {
    path: "/",
    expires,
    httpOnly: false,
  });
  cookie.save("refreshToken", refreshToken, {
    path: "/",
    expires,
    httpOnly: false,
  });
}

// export { saveToken };
