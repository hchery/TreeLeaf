/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {RC} from "@/components/reactor";
import {App as AppProvider, ConfigProvider} from "antd";
import {ThemeProvider} from "antd-style";
import {useStore} from "@/state";
import {makeTheme} from "@/personalize/theme";
import {Routers} from "@/application";
import {BrowserRouter} from "react-router-dom";
import {css} from "@emotion/react";

export const AppRoute = RC(() => {
  return (
    <BrowserRouter>
      <Routers/>
    </BrowserRouter>
  )
})

export const AppTheme = RC(() => {
  const {mode} = useStore().themeStore
  return (
    <ThemeProvider appearance={mode} theme={makeTheme}>
      <AppRoute/>
    </ThemeProvider>
  )
})

export const AppContext = RC(() => {
  return (
    <AppProvider css={css`width: 100%; height: 100%`}>
      <AppTheme/>
    </AppProvider>
  )
})

export const App = RC(() => {
  const {i18n} = useStore().i18nStore
  return (
    <ConfigProvider locale={i18n.antd}>
      <AppContext/>
    </ConfigProvider>
  )
})
