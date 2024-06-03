/**
 * DATE: 2024/6/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

export class KvStorage {

  constructor(private storage: Storage) {
    // Save storage only
    // Nothing to do
  }

  set = (k: string, v: string) => this.storage.setItem(k, v)
  get = (k: string) => this.storage.getItem(k)
  del = (k: string) => this.storage.removeItem(k)
}

const local = new KvStorage(localStorage)
const session = new KvStorage(sessionStorage)

export function useKv() {
  return {
    local: local,
    session: session
  }
}
