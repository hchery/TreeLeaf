/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {RC} from "@/components/reactor";
import {App as AppContext, ConfigProvider} from "antd";
import {ThemeProvider} from "antd-style";
import {useStore} from "@/state";
import {makeTheme} from "@/personalize/theme";
import {Routers} from "@/application";
import {BrowserRouter} from "react-router-dom";

const Theme = RC(() => {
  const {mode} = useStore().themeStore
  return (
    <ThemeProvider appearance={mode} theme={makeTheme}>
      <BrowserRouter>
        <Routers/>
      </BrowserRouter>
    </ThemeProvider>
  )
})

const Context = RC(() => {
  return (
    <AppContext>
      <Theme/>
    </AppContext>
  )
})

export const App = RC(() => {
  const {i18n} = useStore().i18nStore
  return (
    <ConfigProvider locale={i18n.antd}>
      <Context/>
    </ConfigProvider>
  )
})
