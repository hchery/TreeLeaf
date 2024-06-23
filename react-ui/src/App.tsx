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
import {makeI18nAntd} from "@/personalize/i18n";

const AppRoute = RC(() => {
  return (
    <BrowserRouter>
      <Routers/>
    </BrowserRouter>
  )
})

const AppTheme = RC(() => {
  const {mode} = useStore().themeStore
  return (
    <ThemeProvider appearance={mode} theme={makeTheme}>
      <AppRoute/>
    </ThemeProvider>
  )
})

const AppContext = RC(() => {
  return (
    <AppProvider css={css`width: 100%; height: 100%`}>
      <AppTheme/>
    </AppProvider>
  )
})

export const App = RC(() => {
  const {mode} = useStore().i18nStore
  return (
    <ConfigProvider locale={makeI18nAntd(mode)}>
      <AppContext/>
    </ConfigProvider>
  )
})
