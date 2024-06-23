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
import {Card} from "antd";
import {stl} from "@/application/ui/css";
import {LoginTitle} from "@/application/auth/open/login/title";
import {LoginForm} from "@/application/auth/open/login/form";

const useStyles = stl.make(({css}) => ({
  card: css`
    width: 500px;
    height: 400px;
    left: max(0px, calc(50% - 250px));
    top: max(0px, calc(50% - 200px));
  `
}))

const LoginView = RC(() => {
  const {styles} = useStyles()
  return (
    <DocumentTitle title={useI18n("doc.title.auth.login")}>
      <Card className={styles.card} title={<LoginTitle/>}>
        <LoginForm/>
      </Card>
    </DocumentTitle>
  )
})

export const LoginRoute: RouteObject = {
  path: "login",
  element: <LoginView/>
}
