/**
 * DATE: 2024/6/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {Navigate, Outlet, RouteObject, useRoutes} from "react-router-dom";
import {RC} from "@/components/reactor";
import {AuthRoute} from "@/application/auth";
import {NotFoundView} from "@/application/error/404";

export const EntryView = RC(() => {
  return (<Outlet/>)
})

const pagesRoutePoint: RouteObject = {
  children: [
    AuthRoute
  ],
  path: "/ui",
  element: <EntryView/>,
}

export const Routers = () => useRoutes([
  {
    path: "/",
    element: <Navigate to={"/ui/auth/open/login"}/>
  },
  {
    path: "*",
    element: <NotFoundView/>
  },
  pagesRoutePoint
])
