/**
 * DATE: 2024/6/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {SeedToken} from "antd/es/theme/interface";
import {CustomToken} from "antd-style";
import {theme} from "antd";
import {MapToken} from "antd/lib/theme/interface";

export const makeLightTheme = (seedToken: SeedToken, _?: MapToken): CustomToken => ({
  ...theme.defaultAlgorithm(seedToken),
  colorBgLayout: "rgb(240, 240, 240)"
})
