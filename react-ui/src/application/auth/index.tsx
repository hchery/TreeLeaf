/**
 * DATE: 2024/6/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {Outlet, RouteObject} from "react-router-dom";
import {RC} from "@/components/reactor";
import {OpenRoute} from "@/application/auth/open";

export const AuthView = RC(() => {
  return (<Outlet/>)
})

export const AuthRoute: RouteObject = {
  children: [
    OpenRoute
  ],
  path: "auth",
  element: <AuthView/>
}
