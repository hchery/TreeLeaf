/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {Locale} from "antd/es/locale";
import en_us from "@/personalize/i18n/es/en-us";
import zh_cn from "@/personalize/i18n/es/zh-cn";

export type I18nMode = "zh-cn" | "en-us"

export interface I18n {
  antd: Locale
}

export function makeI18n(mode: I18nMode) {
  switch (mode) {
    case "en-us": return en_us
    default: return zh_cn
  }
}
