/**
 * DATE: 2024/6/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {RouteObject} from "react-router-dom";
import {RC} from "@/components/reactor";
import {DocumentTitle} from "@/application/ui/document";
import {useI18n} from "@/state/i18n";

export const LoginView = RC(() => {
  return (
    <DocumentTitle title={useI18n("doc.title.auth.login")}>
      <></>
    </DocumentTitle>
  )
})

export const LoginRoute: RouteObject = {
  path: "login",
  element: <LoginView/>
}
