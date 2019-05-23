queue_direct_test
    这个是我测试的队列，durable代表持久化

queue_stream.anonymous.clxObSNZSISqoefEUqi4mA：
    auto-delete 这个是断开链接的时候会自动删除队列
    exclusive: 这个是，忘记了，反正初始化的时候建立，完了就自己删除，自带auto-delete属性

    现在你看下我断开链接，这个队列删除了，但是之前注册的stream_input 和stream_output的交换机还是继续存在的，不会自动删除
    刚刚你说队列消息丢失的问题，有一定可能是客户端断开链接吧？这个我不清楚，需要你自己验证，
    反正你建立的队列跟queue_stream.anonymous.clxObSNZSISqoefEUqi4mA这个队列是一模一样的
现在测试
    需要测试吗？不需要吧？
    嗯，断开链接是指啥
    这样，我访问http://localhost:9041/send?message=asdf&type=1001，type非100，会有异常，然后会重试，
    不够重试次数的话还会在队列里，在重试的期间我关掉客户端？现在我的生产者和消费者都在这个项目里面，不太好测试，只能关掉项目。
    类似于这样，加入我这个是消费者的项目，那么这个消息还是会存在队列吗，不会的，因为客户端链接不上，这个队列应该会自动删除吧？
    我觉得哈
    不一定 哦哦