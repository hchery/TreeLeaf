/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {MapToken} from "antd/lib/theme/interface";
import {ThemeAppearance} from "antd-style";

export type ThemeMode = ThemeAppearance

export interface BaseToken extends MapToken {
}

export interface ExtraToken {
  fontFamily: string,
  fontFamilyMain: string
}

declare module "antd-style" {
  export interface CustomToken extends BaseToken, ExtraToken {}
}

export * from "./maker"