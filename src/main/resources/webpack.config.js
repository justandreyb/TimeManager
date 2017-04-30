module.exports = {
    entry: {
        app: "./src/main.ts",
        polyfill: "./src/config/polyfill.ts",
        vendor: "./src/config/vendor.ts"
    },
    output: {
        filename: "./out/[name].js"
    },
    module: {
        loaders: [
            {
                test: /\.ts$/,
                loader: 'ts-loader',
                exclude: /node_modules/
            }

        ]
    },
    resolve: {
        extensions: [".js", ".ts"]
    }
};