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
import {Layout} from "antd";
import {stl} from "@/application/ui/css";

export const EntryView = RC(() => {
  return (
    <Layout css={stl.fill}>
      <Outlet/>
    </Layout>
  )
})

const pagesRoutePoint: RouteObject = {
  children: [
    AuthRoute
  ],
  path: "/-v-",
  element: <EntryView/>,
}

export const RootView = RC(() => {
  return (<Navigate to={"/-v-/auth/open/login"}/>)
})

export const Routers = () => useRoutes([
  {
    path: "/",
    element: <RootView/>
  },
  {
    path: "*",
    element: <NotFoundView/>
  },
  pagesRoutePoint
])
