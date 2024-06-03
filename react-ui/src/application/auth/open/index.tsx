/**
 * DATE: 2024/6/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {Outlet, RouteObject} from "react-router-dom";
import {RC} from "@/components/reactor";
import {LoginRoute} from "@/application/auth/open/login";

export const OpenView = RC(() => {
  return (<Outlet/>)
})

export const OpenRoute: RouteObject = {
  children: [
    LoginRoute
  ],
  path: "open",
  element: <OpenView/>
}
