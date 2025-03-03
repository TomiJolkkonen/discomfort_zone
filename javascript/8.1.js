import express from 'express';
import { createProxyMiddleware } from 'http-proxy-middleware';

const app = express();

app.use('/api', createProxyMiddleware({ target: 'http://localhost:3001', changeOrigin: true }));

app.listen(3000, () => {
  console.log('Proxy server running on port 3000');
});