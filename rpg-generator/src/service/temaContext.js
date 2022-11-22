import { createContext } from 'react';

const ColorModeContext = createContext({
    toggleColorMode: () => { },
    mode: 'light'
});

export default ColorModeContext;