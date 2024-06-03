/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

import { IReactComponent } from "mobx-react/dist/types/IReactComponent";
import {observer} from "mobx-react";

// Reactor component
export const RC = <T extends IReactComponent>(_: T) => observer(_)
