/**
 * DATE: 2024/6/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {I18n, I18nMode, makeI18n} from "@/personalize/i18n";
import {makeAutoObservable} from "mobx";

export class I18nStore {

  mode: I18nMode = "zh-cn"
  i18n: I18n = makeI18n(this.mode)

  constructor() {
    makeAutoObservable(this)
  }
}
