
1,翻转每一位数字即可，原理比较简单，我们直接来看图分析
 [image.png](https://pic.leetcode-cn.com/a161e3f0d41ad2866cb2bffe12084963b4e4c2e20086b71e377618d6b944fe4c-image.png)

```
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            //如果数字溢出，直接返回0
            if ((newRes - t) / 10 != res)
                return 0;
            res = newRes;
            x = x / 10;
        }
        return res;
    }
```
2,实际上我们还可以改的更简洁一下
```
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }
```

 [a1b7c667f08bace157ec8fd3e8cb53a.jpg](https://pic.leetcode-cn.com/6838da54f250280af50694e092d08d7fa238b845406a04ca21b7c9d8ac6b4839-a1b7c667f08bace157ec8fd3e8cb53a.jpg)

想查看更多答案，可关注我微信公众号“**数据结构和算法**”，也可以扫描上面二维码关注。
