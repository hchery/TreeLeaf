/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {ThemeAppearance} from "antd-style";
import darkTheme from "@/personalize/theme/es/dark";
import lightTheme from "@/personalize/theme/es/light";

export type ThemeMode = ThemeAppearance

export interface AppToken {
}

export interface StyleToken {
}

declare module "antd-style" {
  export interface CustomToken extends AppToken, StyleToken {}
}

export function makeTheme(mode: ThemeMode) {
  switch (mode) {
    case "dark": return darkTheme
    default: return lightTheme
  }
}
