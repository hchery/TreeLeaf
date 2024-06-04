/**
 * DATE: 2024/6/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {SeedToken} from "antd/es/theme/interface";
import {theme} from "antd";
import {MapToken} from "antd/lib/theme/interface";
import {BaseToken} from "@/personalize/theme";

export const makeLightTheme = (seedToken: SeedToken, _?: MapToken): BaseToken => ({
  ...theme.defaultAlgorithm(seedToken),
  colorBgLayout: "rgb(240, 240, 240)"
})
