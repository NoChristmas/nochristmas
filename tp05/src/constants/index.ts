/**
 * Request successful status code
 */
export const SUCCESS_CODE = 0

/**
 * Request ContentType
 */
export const CONTENT_TYPE = 'application/json'

/**
 * Request timeout time
 */
export const REQUEST_TIMEOUT = 60000

/**
 * Don’t reconstruct the whitelist
 */
export const NO_REDIRECT_WHITE_LIST = ['/login']

/**
 * Do not reset the route of routes
 */
export const NO_RESET_WHITE_LIST = ['Redirect', 'Login', 'NoFind', 'Root']

/**
 * Form default filter setting field
 */
export const DEFAULT_FILTER_COLUMN = ['expand', 'selection']

/**
 * Whether to automatically convey the data format according to Headers-> Content-Type
 */
export const TRANSFORM_REQUEST_DATA = true

export const SHORTCUT_KEYS = {
  save: 'Ctrl+S',
  search: 'Ctrl+F',
  email: 'Ctrl+M',
  excel: 'Ctrl+E'
}

export const CODE_LIST = ['USE_YN', 'COUNTRY', 'PROC']

export const DEFAULT_SERVER_URL = 'localhost:3000'

export const DEFAULT_API_URL = 'localhost:11000'