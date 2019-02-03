package top.lajijson.mblog.common.util;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.*;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis操作工具类
 *
 * @author liuwei
 */
@Slf4j
public class RedissonUtil {

    /**
     * 获取redis终端实例
     */
    private static RedissonClient redissonClient = SpringBeanUtil.getBean(RedissonClient.class);

    /**
     * 获取链接信息
     */
    public static void getRedissonClient() {
        try {
            System.out.println(redissonClient.getConfig().toJSON());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取字符串
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        RBucket rBucket = getRBucket(key);
        if (rBucket.isExists()) {
            return rBucket.get().toString();
        } else {
            log.error("缓存key：{}不存在", key);
            return null;
        }
    }

    /**
     * 设置字符串
     *
     * @param key
     * @param value
     * @param timeToLive
     * @param timeUnit
     */
    public static void setString(String key, String value, long timeToLive, TimeUnit timeUnit) {
        RBucket<String> bucket = getRBucket(key);

        bucket.getAndSet(value);

        if (timeToLive != 0L || timeUnit != null) {
            expir(bucket, timeToLive, timeUnit);
        }
    }

    /**
     * 删除字符串
     *
     * @param key
     */
    public static void deleteString(String key) {
        getRBucket(key).delete();
    }

    /**
     * 设置字符串，无过期时间
     *
     * @param key
     * @param value
     */
    public static void setString(String key, String value) {
        setString(key, value, 0L, null);
    }

    /**
     * 获取map
     *
     * @param key
     * @return
     */
    public static Map<String, String> getMap(String key) {
        return RedissonUtil.<String ,String>getRMap(key).readAllMap();
    }

    /**
     * 设置map
     *
     * @param key
     * @param value
     * @param timeToLive
     * @param timeUnit
     * @param <K>
     * @param <V>
     */
    public static <K, V> void setMap(String key, Map<K, V> value, long timeToLive, TimeUnit timeUnit) {
        getRMap(key).putAll(value);

        RMap<K, V> map = getRMap(key);

        map.putAll(value);

        if (timeToLive != 0L || timeUnit != null) {
            expir(map, timeToLive, timeUnit);
        }
    }

    /**
     * 删除map
     *
     * @param key
     */
    public void deleteMap(String key) {
        getRMap(key).delete();
    }


    /**
     * 设置map，无过期时间
     *
     * @param key
     * @param value
     * @param <K>
     * @param <V>
     */
    public static <K, V> void setMap(String key, Map<K, V> value) {
        setMap(key, value, 0L, null);
    }

    /**
     * 获取字符串对象
     *
     * @param objectName
     * @return
     */
    public static <T> RBucket<T> getRBucket(String objectName) {
        RBucket<T> bucket = redissonClient.getBucket(objectName);
        return bucket;
    }

    /**
     * 获取Map对象
     *
     * @param objectName
     * @return
     */
    public static <K, V> RMap<K, V> getRMap(String objectName) {
        RMap<K, V> map = redissonClient.getMap(objectName);
        return map;
    }

    /**
     * 获取有序集合
     *
     * @param objectName
     * @return
     */
    private <V> RSortedSet<V> getRSortedSet(String objectName) {
        RSortedSet<V> sortedSet = redissonClient.getSortedSet(objectName);
        return sortedSet;
    }

    /**
     * 获取集合
     *
     * @param objectName
     * @return
     */
    private <V> RSet<V> getRSet(String objectName) {
        RSet<V> rSet = redissonClient.getSet(objectName);
        return rSet;
    }

    /**
     * 获取列表
     *
     * @param objectName
     * @return
     */
    public <V> RList<V> getRList(String objectName) {
        RList<V> rList = redissonClient.getList(objectName);
        return rList;
    }

    /**
     * 获取队列
     *
     * @param objectName
     * @return
     */
    private <V> RQueue<V> getRQueue(String objectName) {
        RQueue<V> rQueue = redissonClient.getQueue(objectName);
        return rQueue;
    }

    /**
     * 获取双端队列
     *
     * @param objectName
     * @return
     */
    private <V> RDeque<V> getRDeque(String objectName) {
        RDeque<V> rDeque = redissonClient.getDeque(objectName);
        return rDeque;
    }

    /**
     * 获取锁
     *
     * @param objectName
     * @return
     */
    private RLock getRLock(String objectName) {
        RLock rLock = redissonClient.getLock(objectName);
        return rLock;
    }

    /**
     * 获取原子数
     *
     * @param objectName
     * @return
     */
    private RAtomicLong getRAtomicLong(String objectName) {
        RAtomicLong rAtomicLong = redissonClient.getAtomicLong(objectName);
        return rAtomicLong;
    }

    /**
     * 获取记数锁
     *
     * @param objectName
     * @return
     */
    private RCountDownLatch getRCountDownLatch(String objectName) {
        RCountDownLatch rCountDownLatch = redissonClient.getCountDownLatch(objectName);
        return rCountDownLatch;
    }

    /**
     * 获取消息的Topic
     *
     * @param objectName
     * @return
     */
    private <M> RTopic<M> getRTopic(String objectName) {
        RTopic<M> rTopic = redissonClient.getTopic(objectName);
        return rTopic;
    }

    private static void expir(RExpirable expirable, long timeToLive, TimeUnit timeUnit) {
        expirable.expire(timeToLive, timeUnit);
    }


}
