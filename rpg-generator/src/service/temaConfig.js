const getDesignTokens = (mode) => ({
    palette: {
        mode,
        ...(mode == 'dark')
            ? {
                primary: {
                    main: '#00579D',
                },
                secondary: {
                    main: '#3D3F45',
                },
                tertiary: {
                    main: '#FFFFFF',
                },
                link: {
                    main: '#FFFFFF',
                },
                divider: { main: '#3D3F45' },
                text: {
                    primary: '#FFFFFF',
                    secondary: '#BDBEC0',
                    white: '#FFFFFF'
                },
                background: {
                    default: '#22252C',
                    paper: '#22252C'
                },
                component: {
                    main: '#3D3F45'
                },
                input: {
                    main: '#22252C'
                },
                icon: {
                    main: '#FFFFFF'
                }
            }
            : {
                primary: {
                    main: '#42393B',
                },
                secondary: {
                    main: '#5CACC4',
                },
                tertiary: {
                    main: '#D4F6D6',
                },
                link: {
                    main: '#00579D',
                },
                divider: { main: 'rgba(0, 0, 0, 0.3)' },
                text: {
                    primary: '#000000',
                    secondary: '#5CACC4',
                    white: '#FFFFFF'
                },
                background: {
                    default: '#FFFFFF',
                    paper: '#FFFFFF'
                },
                component: {
                    main: '#EFEFEF'
                },
                input: {
                    main: '#F8F8F8'
                },
                icon: {
                    main: '#FFC897'
                }
            }
    },
    typography: {
        fontFamily: "Inter, sans-serif",
        button: {
            textTransform: 'none',
        }
    }
});

export default getDesignTokens;