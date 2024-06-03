/**
 * DATE: 2024/6/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {RouteObject} from "react-router-dom";
import {RC} from "@/components/reactor";

export const LoginView = RC(() => {
  return (
    <></>
  )
})

export const LoginRoute: RouteObject = {
  path: "login",
  element: <LoginView/>
}
