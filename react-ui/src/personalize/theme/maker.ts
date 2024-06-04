/**
 * DATE: 2024/6/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {makeDarkTheme} from "@/personalize/theme/es/es-dark";
import {makeLightTheme} from "@/personalize/theme/es/es-light";
import {ThemeConfig} from "antd";
import {extraToken} from "@/personalize/theme/es/extra";
import {ThemeMode} from "@/personalize/theme/index";

function getThemeMaker(mode: ThemeMode) {
  switch (mode) {
    case "dark": return makeDarkTheme
    default: return makeLightTheme
  }
}

export function makeTheme(mode: ThemeMode): ThemeConfig {
  return {
    algorithm: (seedToken, mapToken) => ({
      ...getThemeMaker(mode)(seedToken, mapToken),
      ...extraToken
    })
  }
}

