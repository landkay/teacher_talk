module.exports = {
    publicPath: process.env.VUE_APP_IPS_PUBLIC_PATH,
    outputDir: 'ips',
    lintOnSave: false,
    devServer: {
        hot: true,
        open: true,
        port: 8089,
        proxy: {
            '/ips': {
                target: 'http://127.0.0.1:8090',
                changeOrigin: true,
                ws: true,
            }
        }
    }
}