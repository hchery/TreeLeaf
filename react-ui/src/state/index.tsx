/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {createContext, useContext} from "react";
import {Slot} from "@/components/slot";
import {I18nStore} from "@/state/i18n";
import {ThemeStore} from "@/state/theme";

class RootStateStore {
  readonly i18nStore = new I18nStore()
  readonly themeStore = new ThemeStore()
}

const rootStore = new RootStateStore()
const RootStoreContext = createContext(rootStore)

export const RootStoreProvider = ({children}: Slot) => {
  return (
    <RootStoreContext.Provider value={rootStore}>
      {children}
    </RootStoreContext.Provider>
  )
}

export const useStore = () => useContext(RootStoreContext)

