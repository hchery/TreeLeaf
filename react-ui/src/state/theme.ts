/**
 * DATE: 2024/6/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {ThemeMode} from "@/personalize/theme";
import {makeAutoObservable} from "mobx";

export class ThemeStore {

  mode: ThemeMode = "light"

  constructor() {
    makeAutoObservable(this)
  }
}
