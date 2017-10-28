# RxDialog
RxDialog -- 一个基于RxJava的Dialog

RxDialog的作用就是把一个普通的Dialog的按钮点击事件转化成Rxjava的形式。
RxDialog的创建形式：
```
new MyRxDialog(MainActivity.this)
        .setTitle("title")
        .setMessage("Message")
        .setPositiveText("确定")
        .setNegativeText("取消")
        .setNeutralText("中立")
        .dialogToObservable()
        //.dialogToFlowable()
        .subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                switch (integer){
                    case MyRxDialog.POSITIVE:
                        Toast.makeText(MainActivity.this, "Positive", Toast.LENGTH_SHORT).show();
                        break;
                    case MyRxDialog.NEGATIVE:
                        Toast.makeText(MainActivity.this, "Negative", Toast.LENGTH_SHORT).show();
                        break;
                    case MyRxDialog.NEUTRAL:
                        Toast.makeText(MainActivity.this, "Neutral", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Log.e("MyRxDialog", integer+"");
                        break;
                }
            }
        });
```

<a href="http://www.jianshu.com/p/f3283538eaad">原文链接</a>


