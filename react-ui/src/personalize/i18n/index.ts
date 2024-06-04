/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import en_us from "@/personalize/i18n/es/en-us";
import zh_cn from "@/personalize/i18n/es/zh-cn";
import en_US from "antd/locale/en_US"
import zh_CN from "antd/locale/zh_CN";

export type I18nMode = "zh-cn" | "en-us"

export interface I18n {
  "doc.title.auth.login": string
}

export function makeI18n(mode: I18nMode) {
  switch (mode) {
    case "en-us": return en_us
    default: return zh_cn
  }
}

export function makeI18nAntd(mode: I18nMode) {
  switch (mode) {
    case "en-us": return en_US
    default: return zh_CN
  }
}
