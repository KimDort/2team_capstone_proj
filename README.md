# msa-capstone-project
## ๐ซ Team

| ํ  |   ์ฑ๋ช   | ์ง๊ธ | ์์             |
| :-: | :------: | :--: | :--------------- |
|  2  | ๐ ์ต์์ | ๊ณผ์ฅ | ์๋น์ค์ด์2ํ  |
|     |  ํฉ์์ | ๊ณผ์ฅ | ๋์งํธ์ํฌ๊ทธ๋ฃน  |
|     |  ๊น์์ค  | ๋๋ฆฌ | Platform๊ฐ๋ฐํ   |
|     |  ์ด์ฌ์ | ๋๋ฆฌ | ๋์งํธ์ํฌ๊ทธ๋ฃน  |

## ๋ชฉ์ฐจ

- ๋ถ์์ค๊ณ							- ๊ณต๋์์
- SAGA Pattern (Pub / Sub)                           	   - ๊ณต๋์์	
- CQRS Pattern                              		   - ์ด์ฌ์ ๋๋ฆฌ         
- Correlation / Compensation(Unique Key)                   - ์ด์ฌ์ ๋๋ฆฌ
- Request / Response (Feign Client / Sync.Async)   	   - ์ต์์ ๊ณผ์ฅ, ํฉ์์ ๊ณผ์ฅ  
- Gateway                                                  - ๊ณต๋์์
- Deploy / Pipeline					   - ๊ณต๋์์                                  
- Circuit Breaker       				   - ๊น์์ค ๋๋ฆฌ                             
- Autoscale(HPA)  					   - ๊น์์ค ๋๋ฆฌ                                   
- Self-Healing(Liveness Probe) 				   - ๊น์์ค ๋๋ฆฌ                      
- Zero-Downtime Deploy(Readiness Probe)        		   - ์ด์ฌ์ ๋๋ฆฌ      
- Config Map / Persistence Volume            		   - ๊น์์ค ๋๋ฆฌ        
- Polyglot 						   - ์ด์ฌ์ ๋๋ฆฌ

#### ๊ณต๋์์์ ํจ๊ป ์งํํ์์ผ๋ฉฐ ๊ฐ ์๋น์ค๋ณ๋ก ๋ด๋น์๋ฅผ ๋๋์ด ์ํํ์์.

- ์ต์์ - order
- ํฉ์์ - payment
- ๊น์์ค - store
- ์ด์ฌ์ - delivery

--------------------------------------------------
## ๋ถ์ ์ค๊ณ (๊ณตํต)

### ๋ฐฐ๋ฌ์๋ฏผ์กฑ

#### ๊ธฐ๋ฅ์  ์๊ตฌ์ฌํญ
1. ๊ณ ๊ฐ์ด ๋ฉ๋ด๋ฅผ ์ ํํ์ฌ ์ฃผ๋ฌธ ํ ๊ฒฐ์ ํ๋ค.
2. ์ฃผ๋ฌธ์ด ๋๋ฉด ์ฃผ๋ฌธ ๋ด์ญ์ด ์์ ์์ ์ฃผ์ธ์๊ฒ ์ ๋ฌ๋๋ค
3. ์์ ์ฃผ์ธ์ด ํ์ธํ์ฌ ์๋ฆฌํด์ ๋ฐฐ๋ฌ ์ถ๋ฐํ๋ค
4. ๊ณ ๊ฐ์ด ์ฃผ๋ฌธ์ ์ทจ์ํ  ์ ์๋ค
5. ๊ณ ๊ฐ์ด ์ฃผ๋ฌธ์ํ๋ฅผ ์ค๊ฐ์ค๊ฐ ์กฐํํ๋ค

#### ๋น๊ธฐ๋ฅ์  ์๊ตฌ์ฌํญ
1. ํธ๋์ญ์
๊ฒฐ์ ๊ฐ ๋์ง ์์ ์ฃผ๋ฌธ๊ฑด์ ์์ ๊ฑฐ๋๊ฐ ์ฑ๋ฆฝ๋์ง ์์์ผ ํ๋ค (Sync ํธ์ถ)

2. ์ฅ์ ๊ฒฉ๋ฆฌ
์์ ๊ด๋ฆฌ ๊ธฐ๋ฅ์ด ์ํ๋์ง ์๋๋ผ๋ ์ฃผ๋ฌธ์ 365์ผ 24์๊ฐ ๋ฐ์ ์ ์์ด์ผ ํ๋ค Async (event-driven), Eventual Consistency
๊ฒฐ์ ์์คํ์ด ๊ณผ์ค๋๋ฉด ์ฌ์ฉ์๋ฅผ ์ ์๋์ ๋ฐ์ง ์๊ณ  ๊ฒฐ์ ๋ฅผ ์ ์ํ์ ํ๋๋ก ์ ๋ํ๋ค Circuit breaker, fallback

3. ์ฑ๋ฅ
๊ณ ๊ฐ์ด ์์ฃผ ์์ ๊ด๋ฆฌ์์ ํ์ธํ  ์ ์๋ ๋ฐฐ๋ฌ์ํ๋ฅผ ์ฃผ๋ฌธ์์คํ(ํ๋ก ํธ์๋)์์ ํ์ธํ  ์ ์์ด์ผ ํ๋ค CQRS

--------------------------------------------------
## ์ด๋ฒคํธ์คํ ๋ฐ (๊ณตํต)
- ์ด๋ฒคํธ์คํ ๋ฐ ๊ฒฐ๊ณผ

![image](https://user-images.githubusercontent.com/23250734/191643996-1c8d90db-0506-4f55-ad9e-e4a85bd4d625.png)

- ์ฃผ๋ฌธ -> ๋ฐฐ๋ฌ ํ๋ก์ธ์ค

![image](https://user-images.githubusercontent.com/23250734/191655483-b91ea937-f779-4d52-8047-ec465fb21c03.png)

```
1. ๊ณ ๊ฐ์ด ์์์ ์ฃผ๋ฌธํจ๊ณผ ๋์์ ๊ฒฐ์ ๊ฐ ์งํ๋๋ค. (ํธ๋์ญ์)
2. ์์์ ์์ ์ฃผ๋ฌธ ์ ๋ณด๋ฅผ ํ์ธํ๋ค
3. ์กฐ๋ฆฌ๋ฅผ ์์ํ๊ณ  ์์ ์กฐ๋ฆฌ๊ฐ ์๋ฃ๋๋ค.
4. ๋ฐฐ๋ฌ์์ ์ํด ๋ฐฐ๋ฌ์ด ์์๋๋ค.
5. ๋ฐฐ๋ฌ์์ด ์์์ ํฝ์ํ๋ค.
6. ๋ฐฐ๋ฌ์์ด ์์ ๋ฐฐ์ก์ ์๋ฃํ๋ค.
7. ์ฃผ๋ฌธ ์ ์ฒด ๊ณผ์ ์ ๋์๋ณด๋๋ฅผ ํตํด ์ฌ์ฉ์๊ฐ ์กฐํํ๋ค.
```

- ํธ๋์ญ์ 

![image](https://user-images.githubusercontent.com/23250734/191655924-98f7cff8-3a0c-4aab-b04f-2de851d1d7a7.png)
```
์ฃผ๋ฌธ -> ๊ฒฐ์  ๊ณผ์ ์ req/res๋ก ์ฒ๋ฆฌํ์ฌ ํธ๋์ญ์ ์ฒ๋ฆฌํ์๋ค.
๊ฒฐ์ ๊ฐ ์ด๋ฃจ์ด์ง์ง ์์ผ๋ฉด ์ฃผ๋ฌธ์ ์ฑ๋ฆฝ๋์ง ์๋๋ค.
```
- ์ด๋ฒคํธ ์ฒ๋ฆฌ
```
์ฃผ๋ฌธ -> ๊ฒฐ์ ๋ฅผ ์ ์ธํ ๋ชจ๋  ์ก์์ ์ด๋ฒคํธ ๋ฐฉ์์ผ๋ก ์ฒ๋ฆฌํ์๋ค.
์์  ๊ด๋ฆฌ ๊ธฐ๋ฅ์ด ์ํ๋์ง ์๋๋ผ๋ ์ฃผ๋ฌธ์ ๋ฐ์ ์ ์์ผ๋ฉฐ, kafka๋ฅผ ํตํด ๋น๋๊ธฐ ์ฒ๋ฆฌ๋๋ค.
```

--------------------------------------------------
## ์ฌ์  ์ค๋น

kafka ์์ฑ ๋ฐ ๋ชจ๋ํฐ๋ง (docker-compose)

- ๊ธฐ๋ณธ ์ ๊ณต๋ kafka์ kafka-ui๋ฅผ ์ถ๊ฐํ์ฌ kafka๋ฅผ ๋ชจ๋ํฐ๋งํ์์.

```diff
version: '2'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
    ports:
      - 22181:2181
  
  kafka:
    image: confluentinc/cp-kafka:latest
    depends_on:
      - zookeeper
    ports:
      - 9092:9092
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:29092,PLAINTEXT_HOST://localhost:9092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      
+   kafka-ui:
      image: provectuslabs/kafka-ui
      container_name: cluster-kafka-ui
      ports:
        - "9500:8080"
      environment:
        KAFKA_CLUSTERS_0_NAME: local
        KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS: PLAINTEXT://kafka:29092
        KAFKA_CLUSTERS_0_ZOOKEEPER: "zookeeper:2181"
      depends_on:
        - zookeeper
        - kafka
```
- kafka ui ํ์ด์ง์์ ๋ฉ์์ง ์กฐํ

![image](https://user-images.githubusercontent.com/23250734/191666106-e8b6c957-fb70-4d92-8205-456f1530b61b.png)


--------------------------------------------------
## SAGA Pattern (Pub / Sub)
```
SAGA ํจํด์ MSA ๊ฐ๋ฐ ํ๊ฒฝ์์, ๋ถ์ฐ๋ ์ฌ๋ฌ ์๋น์ค๋ค ๊ฐ ๋ฐ์ดํฐ์ ์ผ๊ด์ฑ์ ์งํค๊ธฐ ์ํ ๋ฐฉ๋ฒ ์ค ํ๋.
์ด๋ฒ ๊ต์ก์์  ์ด๋ฒคํธ pub/sub๋ฅผ ํตํ SAGA ํจํด์ ๋ํด ํ์ตํ์์.
์ด๋ฒ ๋ฐฐ๋ฌ์๋ฏผ์กฑ ์ฌ๋ก์์  ์ฌ์ฉ์๊ฐ ์ฃผ๋ฌธ์ ์ทจ์ํ์์ ๋ case๋ก ํ์คํธ๋ฅผ ์งํ.
```
- ์ด๋ฒคํธ์คํ ๋ฐ ํ๋ก์ธ์ค

![image](https://user-images.githubusercontent.com/23250734/191657494-dc6fb681-1c6b-4e0c-8bd2-9f62e3f987e2.png)
```
์ฌ์ฉ์๊ฐ ์ฃผ๋ฌธ์ ์ทจ์ํ๋ฉด, ๊ฒฐ์ /์์  ์ฃผ๋ฌธ์ด ๋์์ ์ทจ์๋์ด์ผ ํ๋ค.
๋ฐ๋ผ์ ์ฃผ๋ฌธ ์ทจ์ ์ด๋ฒคํธ๋ฅผ ๊ฐ ์๋น์ค์์ ์์ ๋ฐ์, ๊ฐ ์๋น์ค์ ์ฃผ๋ฌธ ์ํ๋ฅผ ์๋ฐ์ดํธํ๋ค. (๋น๋๊ธฐ ์ผ๊ด์ฑ ์ ์ง)
```

#### ์ด๋ฒคํธ ๋ฐํ ์์ค
Order.java์ ์ฃผ๋ฌธ ์ทจ์ ์์ค.
```diff
+    //Order.java์์ ์ฃผ๋ฌธ์ด ์ทจ์๋์์ ๋ (DELETE ์์ฒญ) OrderCanceled์ด๋ฒคํธ ๋ฐํ.
+    @PostRemove
    public void onDeletePersist() {
        //order์ทจ์ ์ orderCanceled ์ด๋ฒคํธ ๋ฐํ.
        OrderCanceled orderCanceled = new OrderCanceled(this);

        orderCanceled.setId(this.id);
        orderCanceled.setOrderStatus("CANCELED");

+        orderCanceled.publishAfterCommit();
    }
```


#### ์ด๋ฒคํธ ์์  ์์ค
Payinfo.java์ ์ฃผ๋ฌธ ์ทจ์ ์ด๋ฒคํธ ์์  ์์ค.
```diff
+    //์ฃผ๋ฌธ ์ทจ์ (OrderCanceled ์ด๋ฒคํธ ์์ )
    public static void payCancel(OrderCanceled orderCanceled) {
    
+        //์ทจ์๋ ์ฃผ๋ฌธ ID๋ก pay์ ๋ณด ๊ฒ์ ํ ์ํ ์๋ฐ์ดํธ
        Payinfo payinfo = repository().findByOrderId(orderCanceled.getId());
        if(payinfo != null) {
            payinfo.setStatus("ORDER_CANCELED");
            repository().save(payinfo);
            
+            //์ํ ์๋ฐ์ดํธ ํ ๊ฒฐ์ ์ทจ์ ์ด๋ฒคํธ ๋ฐํ.
            PaymentCanceled paymentCanceled = new PaymentCanceled(payinfo);
            paymentCanceled.publishAfterCommit();
        }
    }
```

Store.java์ ์ฃผ๋ฌธ ์ทจ์ ์ด๋ฒคํธ ์์  ์์ค.
```diff
    public static void orderRecevie(OrderCanceled orderCanceled) {

+        //์ฃผ๋ฌธ ์ทจ์ ์ ๊ด๋ จ store ์ทจ์์ฒ๋ฆฌ.
        Store store = repository().findByOrderId(orderCanceled.getId());
        if(store != null) {
            store.setOrderStatus(orderCanceled.getOrderStatus());
            repository().save(store);
            
            StoreCanceled storeCanceled = new StoreCanceled();
            storeCanceled.setOrderId(orderCanceled.getId());
            storeCanceled.publishAfterCommit();
        }
    }
```

#### ํ์คํธ

์ฃผ๋ฌธ ์ทจ์ ํธ์ถ. (3๋ฒ ์ฃผ๋ฌธ ์ทจ์)
```
http DELETE localhost:8081/orders/3
```

![image](https://user-images.githubusercontent.com/23250734/191670387-a3b7752a-68c1-488b-9edd-d7cde77af7a5.png)

kafka ์ด๋ฒคํธ ๋ก๊ทธ. (์ด๋ฒคํธ ์์ ๊น์ง ํฌํจ.)

์ฃผ๋ฌธ ์ทจ์ -> ๊ฒฐ์  ์ทจ์ / ์์  ์ทจ์๊น์ง ์ฐ์์ ์ผ๋ก ์ด๋ฃจ์ด์ง ๊ฒ์ ํ์ธ ๊ฐ๋ฅ.

![image](https://user-images.githubusercontent.com/23250734/191670577-ae74f15e-d0d6-49b1-b2dc-61a6b1eaf3d1.png)

3๋ฒ ์ฃผ๋ฌธ๊ณผ ์ฐ๊ฒฐ๋ ์์  ์ ๋ณด ์ทจ์๋ ๊ฒ ํ์ธ ๊ฐ๋ฅ. 

![image](https://user-images.githubusercontent.com/23250734/191671603-cab72c63-3625-44da-a74f-41844c3a2e44.png)

3๋ฒ ์ฃผ๋ฌธ๊ณผ ์ฐ๊ฒฐ๋ ๊ฒฐ์ ์ ๋ณด๋ํ ์ทจ์๋จ.

![image](https://user-images.githubusercontent.com/23250734/191671979-196c1513-1073-41e8-92e2-0a26725a7d8a.png)

--------------------------------------------------
## CQRS

```
๋ช๋ น ๋ฐ ์ฟผ๋ฆฌ ์ญํ  ๊ตฌ๋ถ CQRS (Command and Query Responsibility Segregation)
๋ฐ์ดํฐ๋ฅผ ์กฐํํ๋ ๋ถ๋ถ์ ๋ถ๋ฆฌํ๋ ๊ฒ์ผ๋ก ์ดํด.
๋ฐ์ดํฐ๊ฐ ์ค๋ณต์ผ๋ก ์ ์ฅ๋๋๊ฒ์ ๊ฐ์ํ๊ณ , ๋น์ฆ๋์ค ๋ก์ง๊ณผ ๋ฐ์ดํฐ๋ฅผ ์กฐํํ๋ ์์ญ์ ๋ถ๋ฆฌํ๋ ๊ฒ.
์ด๋ฒ ์ค์ต์์  dashboard์๋น์ค๋ฅผ ์์ฑํ์ฌ, ์ฃผ๋ฌธ์ ์ ์ฒด์ ์ธ ์ํ๋ฅผ ์กฐํํ  ์ ์๋๋ก CQRS ์์ฑ.
```
#### Dashboard ์๋น์ค
```
์ต์ด ์ฃผ๋ฌธ์ด ๋์์ ๋, ์์ฑ๋๋ ๋ณ๋์ ๊ฐ์ฒด (์ฃผ๋ฌธ๊ณผ 1:1 ๋งตํ)
๊ฑฐ์ ๋ชจ๋  ์ด๋ฒคํธ๋ฅผ ์์ ํ์ฌ ์ด๋ฒคํธ์ ๋ฐ๋ผ ์ฃผ๋ฌธ์ ์ํ, ๋ ์ง ๋ฑ์ ์๋ฐ์ดํธํ์ฌ ํ๋ฉด์ ๋ณด์ฌ์ค
```

์ด๋ฒคํธ๋ค์ ์์ ํ์ฌ Dashboard ์ ๋ณด๋ฅผ ๋ณ๊ฒฝํ๋ ์์ค - DashBoardViewHandler.java
```diff
+   //Ordered(์ฃผ๋ฌธ๋จ) ์ด๋ฒคํธ ๋ฐ์ ์ Dashboard ๊ฐ์ฒด ์ ๊ท ์์ฑ.
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1(@Payload Ordered ordered) {
        try {
            if (!ordered.validate()) return;

            // view ๊ฐ์ฒด ์์ฑ
            Dashboard dashboard = new Dashboard();
            // view ๊ฐ์ฒด์ ์ด๋ฒคํธ์ Value ๋ฅผ set ํจ
            dashboard.setOrderId(ordered.getId());
            dashboard.setStoreName(ordered.getStoreName());
            dashboard.setItemName(ordered.getItemName());
            dashboard.setItemQty(ordered.getItemQty());
            dashboard.setPrice(ordered.getPrice());
            dashboard.setStatus("ORDERED");
            dashboard.setOrderDt(ordered.getOrderDate());
            // view ๋ ํ์ง ํ ๋ฆฌ์ save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
+   //์ฃผ๋ฌธ์ด ์ทจ์๋์์ ๊ฒฝ์ฐ ์ทจ์ ์ํ๋ก ์๋ฐ์ดํธํ๋ ์์ค. 
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_4(
        @Payload OrderCanceled orderCanceled
    ) {
        try {
            if (!orderCanceled.validate()) return;
            // view ๊ฐ์ฒด ์กฐํ
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(
                orderCanceled.getId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view ๊ฐ์ฒด์ ์ด๋ฒคํธ์ eventDirectValue ๋ฅผ set ํจ
                dashboard.setStatus("ORDER_CANCELED");
                // view ๋ ํ์ง ํ ๋ฆฌ์ save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

#### ๊ฒฐ๊ณผ ํ์ธ

์ฃผ๋ฌธ ์์

![image](https://user-images.githubusercontent.com/23250734/191677781-e6d25546-eae9-4aa3-a727-5e9f6dae0c9c.png)

ํน์  ์ฃผ๋ฌธ ์กฐ๋ฆฌ์๋ฃ

![image](https://user-images.githubusercontent.com/23250734/191677861-5e4b13b1-6779-45a1-a837-22422b93c738.png)

๋์ฌ๋ณด๋ ์ํ ๋ณ๊ฒฝ๋ ๊ฒ ํ์ธ

![image](https://user-images.githubusercontent.com/23250734/191677704-e76ac785-2fb4-49c8-97c7-9e2431900260.png)


--------------------------------------------------
## Correlation / Compensation(Unique Key)

```
์๋น์ค ๊ฐ ๋น๋๊ธฐ ์ด๋ฒคํธํธ์ถ์ ์ํด kafka์ฌ์ฉ.
์ด๋ฒคํธ๋ kafka๋ฉ์์ง๋ก ๋ฐํ๋จ. 
์ฌ์ฉ์ ๋์์ ๋ฐ๋ผ kafka๋ก ์ด๋ฒคํธ๊ฐ ๋ฐํ๋๋ ๊ฒ์ ํ์ธํ๋ค.
```

๊ฐ ์๋น์ค๋ณ application.yml ํ์ผ.

```diff
spring:
  profiles: default
  jpa:
    properties:
      hibernate:
        show_sql: true
        format_sql: true
  cloud:
    stream:
+      kafka:   //์๋น์ค ๊ฐ ๋น๋๊ธฐ ํต์ ์ ์ํด kafka๋ฅผ ์ฌ์ฉ.
        binder:
          brokers: localhost:9092   //kafka์ฃผ์.
        streams:
          binder:
            configuration:
              default:
                key:
                  serde: org.apache.kafka.common.serialization.Serdes$StringSerde
                value:
                  serde: org.apache.kafka.common.serialization.Serdes$StringSerde
      bindings:
        event-in:
          group: dashboard
          destination: teamcapstone
          contentType: application/json
        event-out:
          destination: teamcapstone
          contentType: application/json
```

kafka ์ด๋ฒคํธ ๋ฐ์ก. - AbsctractEvent.java
```
//์ค์ ๋ kafka์ค์ ์ ๋ฐ๋ผ ์ด๋ฒคํธ ๋ฐํ.
public void publish() {
        /**
         * spring streams ๋ฐฉ์
         */
        KafkaProcessor processor = OrderApplication.applicationContext.getBean(
            KafkaProcessor.class
        );
        MessageChannel outputChannel = processor.outboundTopic();

        outputChannel.send(
            MessageBuilder
                .withPayload(this)
                .setHeader(
                    MessageHeaders.CONTENT_TYPE,
                    MimeTypeUtils.APPLICATION_JSON
                )
                .setHeader("type", getEventType())
                .build()
        );
    }
```

์ฃผ๋ฌธ ์คํ

![image](https://user-images.githubusercontent.com/23250734/191680811-011b2741-b24b-415e-8f9e-931e1b48ea3b.png)

kafka ๋ฉ์์ง ๋ฐ์ก ํ์ธ.

![image](https://user-images.githubusercontent.com/23250734/191680880-c573d299-ad40-45b4-a196-2c52218fe4a4.png)

๋ฉ์์ง ๋ด์ฉ ํ์ธ (Ordered์ด๋ฒคํธ)

application.yml์ ์ค์ ํ kafka์ค์ ์ ๋ฐ๋ผ jsonํ์์ผ๋ก ์ด๋ฒคํธ ๋ฐํ.

```
{
	"eventType":"Ordered",
	"timestamp":1663830408970,
	"id":7,
	"storeName":"์คํ ์ด99",
	"itemName":null,
	"itemQty":21,
	"price":22000,
	"orderStatus":null,
	"orderDate":null
}
```


--------------------------------------------------
## Req / Resp (feign client)

์ด๋ฒคํธ์คํ ๋ฐ ์ค ์ฃผ๋ฌธ-๊ฒฐ์  ๋ถ๋ถ

![image](https://user-images.githubusercontent.com/23250734/191682661-7f6b9ff0-2e95-4edc-a80c-e6921893a8b4.png)

```
์๊ตฌ์ฌํญ ์ค ์ฃผ๋ฌธ-๊ฒฐ์  ํธ๋์ญ์ ์ฒ๋ฆฌ๋ฅผ ์ํด Pub/Sub ๋ฐฉ์์ด ์๋ Req/Res๋ฐฉ์์ผ๋ก ์ด๋ฒคํธ ์ฒ๋ฆฌ.
์ฃผ๋ฌธ ์ ๊ฒฐ์ ๊ฐ ํ๋ฒ์ ์งํ๋์ด์ผ ํ๊ณ , ๊ฒฐ์ ์ ๋ฌธ์ ๊ฐ ์๊ฒผ์ ๊ฒฝ์ฐ ์ฃผ๋ฌธ ์ด๋ฒคํธ๋ ๋ฐํ๋์ง ์์.
ํ ์๋น์ค๋ฅผ Req/Res๋ฐฉ์์ผ๋ก ํธ์ถํ๊ธฐ ์ํด @FeignClient ์ด๋ธํ์ด์ ์ฌ์ฉ.
```

์ฃผ๋ฌธ ์ด๋ฒคํธ ๋ฐํ ๋ถ๋ถ (Order.java)

```diff
    @PostPersist
    public void onPostPersist() {
        teamcapstone.external.Payinfo payinfo = new teamcapstone.external.Payinfo();
        payinfo.setOrderId(id);
        payinfo.setPrice((double)price);
        payinfo.setStatus(orderStatus);
        
+        //Order์์ฑ ์ Payment๋ ์์ฑ (req/res). pay์ ๋ณด ์์ฑ ์๋ฃ ์ Ordered์ด๋ฒคํธ ๋ฐํ.
+        OrderApplication.applicationContext
+            .getBean(teamcapstone.external.PayinfoService.class)
+            .pay(payinfo);

        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();
    }
```

์ฃผ๋ฌธ ์ด๋ฒคํธ ๋ฐํ ์  ๊ฒฐ์  ํธ์ถ(Req) ๋ถ๋ถ - PayinfoService.java

```diff
+// FeignClient ์ด๋ธํ์ด์์ ํตํด 8084ํฌํธ์์ ๋์์ค์ธ Payment์๋น์ค๋ฅผ ์ง์  ํธ์ถ. (๋๊ธฐ)
+@FeignClient(name = "payment", url = "http://localhost:8084")
public interface PayinfoService {
    @RequestMapping(method = RequestMethod.POST, path = "/payinfos")
    public void pay(@RequestBody Payinfo payinfo);
    // keep
}
```

#### ํ์คํธ

์ฃผ๋ฌธ ์ด๋ฒคํธ ํธ์ถ ์ kafka ์ด๋ฒคํธ ๋ฐํ ๋ก๊ทธ ํ์ธ.

![image](https://user-images.githubusercontent.com/23250734/191683558-95e0293f-fd02-4075-a9c7-5df9c5c2f9bb.png)

๊ฒฐ์  ์๋น์ค ์ค๋จ ํ ์ฃผ๋ฌธ ํธ์ถ ์, ์ฃผ๋ฌธ ์์ฒด๊ฐ ๋์ง ์๋ ๊ฒ์ ํ์ธํ  ์ ์์ (500์๋ฌ)
 
![image](https://user-images.githubusercontent.com/23250734/191683676-f547d93e-6f00-44db-bd3b-50bf016d0504.png)


--------------------------------------------------
## gateway

```
์ฌ๋ฌ ๋ง์ดํฌ๋ก์๋น์ค๋ฅผ ์คํ ์, ๊ฐ ๋ง์ดํฌ๋ก์๋น์ค๋ก์ ์ง์์ ์ด ๋ฌ๋ผ ํฌํธ ๋ฒํธ๋ฅผ ์ ๋ถ ์ง์ ํด์ ํธ์ถํด์ผ ํ๋ ๋ฌธ์ ๋ฅผ ํด๊ฒฐํ๊ธฐ ์ํด gateway์ฌ์ฉ.
์ด๋ฒ ์ค์ต์์  spring-cloud์์ ์ ๊ณตํ๋ gateway๊ธฐ๋ฅ์ ํตํด ๊ตฌํํ์์.
```

gateway ์์ฑ์ ์ํ application.yml ํ์ผ.

```diff
server:
+  port: 8088   //gateway ํฌํธ. gatewayํฌํธ๋ก ๋ค์ด์ค๋ฉด ํ์ URL์ ๋ฐ๋ผ ๊ฐ๊ฐ์ ์๋น์ค๋ก redirect์์ผ์ค.

---
spring:
  profiles: default
  cloud:
    gateway:
      routes:
+      //์๋ routes๊ฒฝ๋ก์ ์๋น์ค๋ค์ ์ ๋ณด๋ฅผ ์๋ ฅ. /orders/~~๊ฐ ํฌํจ๋ URL๋ก gateway์ ์ ๊ทผํ๋ฉด, 8081 ํฌํธ์ ๋  ์๋ order์๋น์ค๋ก redirect์์ผ์ค.
+        - id: order
+          uri: http://localhost:8081
+          predicates:
+            - Path=/orders/**, 
        - id: store
          uri: http://localhost:8082
          predicates:
            - Path=/stores/**, 
        - id: delivery
          uri: http://localhost:8083
          predicates:
            - Path=/deliveries/**, 
        - id: payment
          uri: http://localhost:8084
          predicates:
            - Path=/payinfos/**, 
        - id: dashboard
          uri: http://localhost:8085
          predicates:
            - Path=, /dashboards/**
+            //ํน์  ๊ฒฝ๋ก๊ฐ ์์ ์ 8080ํฌํธ๋ก ๋์์ง ํ๋ก ํธ์๋ ํธ์ถ.
+        - id: frontend
+          uri: http://localhost:8080
+          predicates:
+            - Path=/**
      globalcors:
        corsConfigurations:
          '[/**]':
            allowedOrigins:
              - "*"
            allowedMethods:
              - "*"
            allowedHeaders:
              - "*"
            allowCredentials: true
```

ํ์คํธ

![image](https://user-images.githubusercontent.com/23250734/191675243-a11c2059-c4c4-44e8-b172-94f1c6a6517b.png)

![image](https://user-images.githubusercontent.com/23250734/191675583-68e5f227-7634-423e-b18a-7a31d6c2288a.png)


--------------------------------------------------
## Deploy / pipeline

```
์ฟ ๋ฒ๋คํฐ์ค๋ .yaml/yml ํ์ผ์ ์ค์ ๋ ๋ด์ฉ์ ํตํด ์๋์ผ๋ก ๋ฐฐํฌํ๊ณ  ์ํ๋ฅผ ์ ์งํ  ์ ์๋ค.
์ด๋ฒ ํ๋ก์ ํธ์์  ์๋น์ค๋ฅผ ํจํค์ง ํ docker hub์ ์ด๋ฏธ์ง๋ก ์๋ก๋, ์ฟ ๋ฒ๋คํฐ์ค ํด๋ฌ์คํฐ์ ๋ฐฐํฌํ์๋ค.
์๋๋ order์๋น์ค ํ์คํธ ๊ฒฐ๊ณผ.
```

#### ์ฌ์  ์ค๋น์ฌํญ

- AWS ํด๋ฌ์คํฐ๋ ๋ฏธ๋ฆฌ ์์ฑํด์ ์ฐ๊ฒฐํ์์.
- helm์ ํตํ kafka๋ ๋ฏธ๋ฆฌ ์์ฑํ์์.
- dockerHub์๋ ๋ฏธ๋ฆฌ ๋ก๊ทธ์ธ๋์์.

#### ์ด๋ฏธ์ง ๋น๋ ๋ฐ ๋ฐฐํฌ

##### 1. order์๋น์ค์ application.yml ํ์ธ

application.yml์ ํ๋จ์ docker์ด๋ฏธ์ง๋ก ๋น๋๋๋ ๊ฒฝ์ฐ ์ฌ์ฉํ  ์ค์ ์ด ๋ฐ๋ก ์กด์ฌํ๋ค.

ํด๋น ์ค์ ์ kafka์ฃผ์๋ฅผ ํ์ธํ๋ค.

```diff
spring:
  profiles: docker
  cloud:
    stream:
      kafka:
        binder:
+          brokers: my-kafka:9092			//kafka ์ฃผ์ ํ์ธ
        streams:
          binder:
            configuration:
              default:
                key:
                  serde: org.apache.kafka.common.serialization.Serdes$StringSerde
                value:
                  serde: org.apache.kafka.common.serialization.Serdes$StringSerde
      bindings:
        event-in:
          group: order
          destination: teamcapstone
          contentType: application/json
        event-out:
          destination: teamcapstone
          contentType: application/json
```


##### 2. order์๋น์ค ํจํค์ง

order์๋น์ค ํด๋ ์ต์๋จ์ผ๋ก ์ด๋ ํ ์๋์ ๋ช๋ น์ด๋ฅผ ์๋ ฅํ๋ค

```
//๋ฉ์ด๋ธ ํจํค์ง
mvn package -Dmaven.test.skip
```

ํจํค์ง ๊ฒฐ๊ณผ targetํด๋์ SNAPSHOTํ์ผ์ด ์์ฑ๋๋ค.

![image](https://user-images.githubusercontent.com/23250734/191693683-993440cd-008a-4da7-91f3-870f6fe76280.png)


##### 3. ๋์ปค ์ด๋ฏธ์ง ๋น๋. (Dockerfileํ์ธ)

order์๋น์ค ์ต์๋จ์ ์๋ dockerfile์ ํ์ธํ๋ค.
```
FROM openjdk:15-jdk-alpine		//javaํ๋ก๊ทธ๋จ์ ๊ธฐ๋ฐ์ผ๋ก SNAPSHOT.jar์ ์๋ ํ์ผ๋ค์ ์ด๋ฏธ์ง๋ก ๋ฌถ๋๋ค๋ ๋ด์ฉ.
COPY target/*SNAPSHOT.jar app.jar
EXPOSE 8080
ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT ["java","-Xmx400M","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=docker"]
```

๋์ปค ์ด๋ฏธ์ง ๋น๋
```
//dockerํ์ผ์ด ์๋ ๊ฒฝ๋ก์์ ์ํ
docker build -t vkv6581/order:v1 .
```

๋์ปค ์ด๋ฏธ์ง ํ์ธ
```
docker images
```

![image](https://user-images.githubusercontent.com/23250734/191694867-f73b04e4-126c-4aa5-a4b8-57105ab0df6f.png)


#### 4. ๋์ปค ํ๋ธ์ ์๋ก๋.
```
docker push vkv6581/order:v1 -t
```

๋์ปคํ๋ธ์ ์ด๋ฏธ์ง ์๋ก๋๋ ๊ฒ ํ์ธ.

![image](https://user-images.githubusercontent.com/23250734/191695211-e32bdcb8-466d-4039-9d9f-5411c467fb3d.png)


#### 5. ์ฟ ๋ฒ๋คํฐ์ค pod deploy

order ์๋น์ค ์ต์๋จ ํด๋ kubernetes ํด๋ ํ์์ deployment.yamlํ์ผ ํ์ธ.

```diff
apiVersion: apps/v1
+kind: Deployment		//pods ์ข๋ฅ.
metadata:
  name: order
  labels:
    app: order
spec:
+  replicas: 3			//๋ณต์ ๋ณธ ์ 
  selector:
    matchLabels:
      app: order
  template:
    metadata:
      labels:
        app: order
    spec:
      containers:
        - name: order
+          image: vkv6581/order:v1		//๋ฐฐํฌํ  ์ด๋ฏธ์ง docker hub ์ฃผ์.
          ports:
            - containerPort: 8080
          readinessProbe:
            httpGet:
              path: '/actuator/health'
              port: 8080
            initialDelaySeconds: 10
            timeoutSeconds: 2
            periodSeconds: 5
            failureThreshold: 10
          livenessProbe:
            httpGet:
              path: '/actuator/health'
              port: 8080
            initialDelaySeconds: 120
            timeoutSeconds: 2
            periodSeconds: 5
            failureThreshold: 5

```

#### 6. ์ฟ ๋ฒ๋คํฐ์ค pod ๋ฐฐํฌ
5๋ฒ์์ ์งํํ๋ ๋์ผํ ๊ฒฝ๋ก์์ ์๋์ ๋ฐฐํฌ ๋ช๋ น์ด ์คํ
```
kubectl apply -f deployment.yaml
```

pod์์ฑ ํ์ธ
```
kubectl get pods
```

replicaset์ด 3๊ฐ์ด๊ธฐ ๋๋ฌธ์ 3๊ฐ์ pods๊ฐ ์์ฑ๋ ๊ฒ์ ํ์ธํ  ์ ์์.

![image](https://user-images.githubusercontent.com/23250734/191695875-b2edd74a-4b23-47fc-a7fa-35d1b13fe971.png)


#### 7. ์ธ๋ถ ์ ์์ ์ํ service ๋ฐฐํฌ.
๋์ผํ ๊ฒฝ๋ก์์ ์๋์ ๋ฐฐํฌ ๋ช๋ น์ด ์คํ (์๋น์ค ๋ฐฐํฌ)
์๋น์ค : pods์ ์ง์  ์ ์ํ๋ ๊ฒ์ด ์๋๋ผ order์๋น์ค์ ๋ฐฐํฌํ๊ธฐ ์ํ ์ง์๊ตฌ.
```
kubectl apply -f service.yaml
```

์๋น์ค ์์ฑ๋ ๊ฒ ํ์ธ

![image](https://user-images.githubusercontent.com/23250734/191696518-79b00828-4f3f-4bfd-b34f-5589c3ef9b67.png)


#### 8. order ์๋น์ค ํ์คํธ๋ฅผ ์ํ ํฌํธํฌ์๋ฉ
์ฝ์์์ 8080์ผ๋ก ํ์คํธ๋ฅผ ์ํด order ์๋น์ค ํฌํธํฌ์๋ฉ
```
kubectl port-forward deploy/order 8080:8080
```

![image](https://user-images.githubusercontent.com/23250734/191697137-66a25220-e2ab-480e-b669-edf2c908feb8.png)

์ฝ์์์ 8080ํฌํธ๋ก ํธ์ถ ์ ์ ์ ๋์ํ๋๊ฒ ํ์ธ ๊ฐ๋ฅ.

![image](https://user-images.githubusercontent.com/23250734/191697326-c11f5bfb-f28c-4a8e-858d-85a572887cee.png)

--------------------------------------------------
## Circuit Breaker
```
MSA๋ก ์๋น์ค ๊ตฌ์ถ ์, ํน์  ์๋น์ค๋ pod๊ฐ ๋์ํ์ง ์์ ๋
ํด๋น ์๋น์ค๋ก ๊ฐ๋ ์์ฒญ์ ์ฌ์ ์ ์ฐจ๋จํด ๋ถํ๋ ์ฅ์  ์ ํ๋ฅผ ๋ฐฉ์งํ  ์ ์๋ค. (์ํท๋ธ๋ ์ด์ปค)

์ํท๋ธ๋ ์ด์ปค ์ข๋ฅ๋ ๋ง์ผ๋, ์ด๋ฒ ํ ํ๋ก์ ํธ์์  istio๋ฅผ ํตํ ์ํท๋ธ๋ ์ด์ปค๋ฅผ ๊ตฌ์ถํ๊ณ  ํ์คํธํ์๋ค.
```
#### ์ฌ์  ์์
- ์ฟ ๋ฒ๋คํฐ์ค์ istio๋ฐฐํฌ ๋ฐ ์๋น์ค ์ฐ๊ฒฐ

#### ํ์คํธ

์ํท๋ธ๋ ์ด์ปค ์ค์  - order ์๋น์ค์ ์ํท ๋ธ๋ ์ด์ปค๋ฅผ ์ค์ ํจ.

```diff
kubectl apply -f - << EOF
  apiVersion: networking.istio.io/v1alpha3
  kind: DestinationRule
  metadata:
    name: dr-delivery
    namespace: tutorial
  spec:
    host: order
    trafficPolicy:
      loadBalancer:
        simple: ROUND_ROBIN		
      outlierDetection:
        consecutive5xxErrors: 1
        interval: 1s
+        baseEjectionTime: 3m		//์ฅ์  ๋ฐ์ ์ 3๋ถ๋์ ์์ฒญ ๋์์์ ์ ์ธ์ํด.
        maxEjectionPercent: 100
EOF
```

์ํท๋ธ๋ ์ด์ปค ์ค์  ํ ํ๋์ pod๋ฅผ down์ํค๋ฉด istio ์ํท๋ธ๋ ์ด์ปค์ ์ํด ํด๋น pod๋ก 3๋ถ๋์ ์์ฒญ์ด ๊ฐ์ง ์๋๋ค.

![image](https://user-images.githubusercontent.com/23250734/191890867-9dbac988-d071-44c5-9399-c4afebf49aff.png)


--------------------------------------------------
## Autoscale(HPA)

```
์ฟ ๋ฒ๋คํฐ์ค ์ค์ ์ ํตํด ์๋น์ค์ ๋ถํ ๋ฐ์ ์ ์ฌ๋ถ์ pod๋ฅผ ์์ฑํด ๋ถํ ๋ถ์ฐ์ ํ  ์ ์์ (์คํ ์ค์ผ์ผ๋ง)
```

#### ์ฌ์  ์์
```
//order deployment์ ์คํ ์ค์ผ์ผ๋ง ์ค์ .
kubectl autoscale deployment order --cpu-percent=20 --min=1 --max=3
```

#### ์คํ ์ค์ผ์ผ๋ง ํ์คํธ

๋ถํ ์  ์ผ๋ฐ์ ์ธ ์ํ์ pod๋ชฉ๋ก

![Att496C tmp](https://user-images.githubusercontent.com/23250734/191880960-d7254a70-b7a0-4915-bd39-b46dfbda5900.png)

๋ถํ ๋ฐ์

![image](https://user-images.githubusercontent.com/23250734/191881023-ebff8a29-10a7-49a2-afc4-0384097036c8.png)

์คํ ์ค์ผ์ผ

![image](https://user-images.githubusercontent.com/23250734/191881093-2155115b-c677-4338-974e-44ecd4e56d00.png)


--------------------------------------------------
## Self-Healing(Liveness Probe)
```
yaml์ ํตํ ์ฟ ๋ฒ๋คํฐ์ค ๋ฐฐํฌ ์, 
Liveness Probe ์ค์ ์ ํตํด ๋ฌธ์ ๊ฐ ์๋ pod๋ฅผ ์ ์ธ ํ ๋ค๋ฅธ pod๋ฅผ ์์ฑํ๋ self-healing ๊ตฌํ์ด ๊ฐ๋ฅํ๋ค.
Liveness Probe๋ฅผ ์ค์ ํ๋ฉด ์ฟ ๋ฒ๋คํฐ์ค์์ ์ฃผ๊ธฐ์ ์ผ๋ก pod์ ์ํ๋ฅผ ์ฒดํฌํด, ๋ฌธ์ ๊ฐ ์๋ pod์ข๋ฃ ํ ์๋ก์ด pod๋ฅผ ์์ฑํ๋ค.

์๋ ์์ฑ๋ ํ๋ก์ ํธ ์ฝ๋์์  spring boot actuator๋ฅผ ์ฌ์ฉํด ์ํ๋ฅผ ์ฒดํฌํ๋ค.
```

์ฌ์  ์ค๋น์ฌํญ

livenessProbe ์ํ shutdown์ ์ํด order์๋น์ค application.yml์ ์๋์ ์ค์  ์ถ๊ฐ.

```diff
spring:
  profiles: docker
  cloud:
    stream:
      kafka:
        binder:
          brokers: my-kafka:9092
        streams:
          binder:
            configuration:
              default:
                key:
                  serde: org.apache.kafka.common.serialization.Serdes$StringSerde
                value:
                  serde: org.apache.kafka.common.serialization.Serdes$StringSerde
      bindings:
        event-in:
          group: order
          destination: teamcapstone
          contentType: application/json
        event-out:
          destination: teamcapstone
          contentType: application/json

api:
  url:
    payment: payment:8080

+management:
+  endpoint:
+    health:
+      show-details: "ALWAYS"
+    shutdown:
+      enabled: true		//health-check shutdown ๋ช๋ น์ด ์ฌ์ฉ์ ์ํด ์ถ๊ฐ.
+  endpoints:
+    web:
+      exposure:
+        include: "*"

```

deployment.yamlํ์ผ

```diff
apiVersion: apps/v1
kind: Deployment
metadata:
  name: order
  labels:
    app: order
spec:
  replicas: 1
  selector:
    matchLabels:
      app: order
  template:
    metadata:
      labels:
        app: order
    spec:
      containers:
        - name: order
          image: vkv6581/order:v1.4
          ports:
            - containerPort: 8080
          readinessProbe:
            httpGet:
              path: '/actuator/health'
              port: 8080
            initialDelaySeconds: 10
            timeoutSeconds: 2
            periodSeconds: 5
            failureThreshold: 10
+          livenessProbe:
+            httpGet:
+              path: '/actuator/health'			//ํด๋น ์ฃผ์๋ก helath-check
+              port: 8080
+            initialDelaySeconds: 120
+            timeoutSeconds: 2
+            periodSeconds: 5
+            failureThreshold: 5
```

#### ํ์คํธ

pods ๋ชฉ๋ก ํ์ธ.

![image](https://user-images.githubusercontent.com/23250734/191878048-ae86d3fc-535f-433b-b677-3addfe310d4d.png)

order ์๋น์ค์ actuator shutdown๋ช๋ น์ด๋ฅผ ํตํด ์ง๋ค์ด.

```
http POST localhost:8080/actuator/shutdown
```

![image](https://user-images.githubusercontent.com/23250734/191878227-0b7f3c94-5eda-4789-ae90-31367c08a97a.png)


pods๊ฐ ๋ด๋ ค๊ฐ๊ณ , ์ฌ์๋ ํ์๊ฐ 1 ์ฆ๊ฐํ ๋ชจ์ต์ ํ์ธํ  ์ ์๋ค.

![image](https://user-images.githubusercontent.com/23250734/191878356-5014d171-9cb3-4ee2-bea4-a5af76276f07.png)

์ฝ๊ฐ์ ์๊ฐ์ด ์ง๋ ํ pods ์ ์ ์ํ๋ก ์๋ ๋ณต๊ตฌ๋ ๋ชจ์ต ํ์ธ.

![image](https://user-images.githubusercontent.com/23250734/191878380-84d2a134-34a7-4d96-b8f7-71f8e5ff82e9.png)


--------------------------------------------------
## Zero-Downtime Deploy(Readiness Probe) 
```
yaml์ ํตํ ์ฟ ๋ฒ๋คํฐ์ค ๋ฐฐํฌ ์, 
Readiness Probe ์ค์ ์ ํตํด ๋ฌด์ค๋จ ๋ฐฐํฌ๊ฐ ๊ฐ๋ฅํ๋ค.

Readiness Probe๋ฅผ ์ค์ ํ๋ฉด ์ฟ ๋ฒ๋คํฐ์ค์์ ์ฃผ๊ธฐ์ ์ผ๋ก pod์ ์ํ๋ฅผ ์ฒดํฌํด, ์ ์์ธ ๊ฒฝ์ฐ๋ง ํธ๋ํฝ์ ๋ณด๋ด๊ฒ ๋๋ค.
```

#### - ์ผ๋ฐ์ ์ธ ๋ฐฐํฌ 

์๋์ฒ๋ผ deployment.yamlํ์ผ ์๋์ readinessprobe ์ ๊ฑฐํ ํ ๋ฐฐํฌํ๋ค.

```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: order
  labels:
    app: order
spec:
  replicas: 4
  selector:
    matchLabels:
      app: order
  template:
    metadata:
      labels:
        app: order
    spec:
      containers:
        - name: order
          image: vkv6581/order:v1
          ports:
            - containerPort: 8080
-          readinessProbe:
-            httpGet:
-              path: '/actuator/health'
-              port: 8080
-            initialDelaySeconds: 10
-            timeoutSeconds: 2
-            periodSeconds: 5
-            failureThreshold: 10
          # livenessProbe:
          #   httpGet:
          #     path: '/actuator/health'
          #     port: 8080
          #   initialDelaySeconds: 120
          #   timeoutSeconds: 2
          #   periodSeconds: 5
          #   failureThreshold: 5
```

siege๋ฅผ ํตํด ๋ฐฐํฌ ์ ์๋น์ค ์ค๋จ์ ํ์ธ

![image](https://user-images.githubusercontent.com/23250734/191700323-fdb704ce-60d4-4857-a4f3-3239321e2946.png)


#### ๋ฌด์ค๋จ ๋ฐฐํฌ 

deployment.yaml์ readinessProbe ๊ด๋ จ ์ค์  ์ถ๊ฐ.

```diff
apiVersion: apps/v1
kind: Deployment
metadata:
  name: order
  labels:
    app: order
spec:
  replicas: 4
  selector:
    matchLabels:
      app: order
  template:
    metadata:
      labels:
        app: order
    spec:
      containers:
        - name: order
          image: vkv6581/order:v1
          ports:
            - containerPort: 8080
+          readinessProbe:
+            httpGet:
+              path: '/actuator/health'		//์ํ ์ฒดํฌ URL
+              port: 8080
+            initialDelaySeconds: 10
+            timeoutSeconds: 2
+            periodSeconds: 5
+            failureThreshold: 10
#          livenessProbe:
#            httpGet:
#              path: '/actuator/health'
#              port: 8080
#            initialDelaySeconds: 120
#            timeoutSeconds: 2
#            periodSeconds: 5
#            failureThreshold: 5
```

๋ณ๊ฒฝ ํ ๋ฐฐํฌ.

![image](https://user-images.githubusercontent.com/23250734/191700716-a44cea05-cb6f-4a99-a7a7-1f0c5b1c6306.png)

siege๋ฅผ ํตํด ์ง์์ ์ธ ํธ์ถ์ ํ์์ง๋ง, ์ค๋จ๋์ง ์๋ ๊ฒ์ ํ์ธํ  ์ ์๋ค.

![image](https://user-images.githubusercontent.com/23250734/191700800-2a46f200-f7fe-4433-b449-af35720c9ab6.png)


--------------------------------------------------
## Config Map / Persistence Volume

```
์ผ๋ฐ์ ์ผ๋ก Pod๋ ์ข๋ฃ/์ฌ์์ฑ๋  ๊ฒฝ์ฐ ๊ฐ์ง๊ณ  ์๋ ๋ฐ์ดํฐ๋ฅผ ์์ด๋ฒ๋ฆฐ๋ค.
๋ฐ๋ผ์ ์ฟ ๋ฒ๋คํฐ์ค์์  ๋ฐ์ดํฐ๋ฅผ ์ ์ฅํ  ๊ณต๊ฐ์ ๋ง๋ค ์ ์๋๋ก ์ ๊ณตํ๋๋ฐ ์ด๋ฅผ Persistence Volumn์ด๋ผ๊ณ  ํ๋ค.

๋ํ ๊ฐ ์๋น์ค์์ DB์ ์ ๊ทผ์ด ํ์ํ  ๊ฒฝ์ฐ, DB์ ์์ ๋ณด๋ ํจ์ค์๋ ๊ฐ์ ์ค์ , ๋ฏผ๊ฐ์ ๋ณด๋ค์ ๊ณตํต์ผ๋ก ์ฌ์ฉํ๊ฒ ๋๋ค.
์ฟ ๋ฒ๋คํฐ์ค์์  ์ด๋ฐ ์ ๋ณด ๊ด๋ฆฌ๋ฅผ ์ํด ConfigMap, Secret๊ณผ ๊ฐ์ ๊ฐ์ฒด๋ฅผ ์ ๊ณตํ๋ค.

Mysql DB ์์ฑ ํ ์๋น์ค์ ์ฐ๊ฒฐ, pod ์ฌ์์ ํ ๋ฐ์ดํฐ๊ฐ ์ ์ค๋์ง ์๋ ๊ฒ์ ํ์คํธํ๋ค.
```
#### mysql ์ค๋น

mysql ๋ฐฐํฌ๋ฅผ ์ํ yaml ์์ฑ ํ ์ฟ ๋ฒ๋คํฐ์ค์ ๋ฐฐํฌํ๋ค.

mysql-pvc.yaml

```diff
apiVersion: v1
+kind: PersistentVolumeClaim	//PVC ์์ฑ.
metadata:
  name: fs
  labels:
    app: test-pvc
spec:
  accessModes:
  - ReadWriteOnce
  resources:
    requests:
      storage: 1Mi
```

![image](https://user-images.githubusercontent.com/23250734/191880907-4904b240-a6ad-4e8c-933d-c5d2f7345d45.png)



mysqlsecret.yaml

```diff
apiVersion: v1
+ kind: Secret		//์ํฌ๋ฆฟ ์์ฑ
metadata:
  name: mysql-pass
  namespace: msa
type: Opaque
data:
+  password: *******		//ํจ์ค์๋ ์ ์ฅ.
---
apiVersion: v1
kind: ConfigMap
metadata:
  name: mysql-config
  namespace: msa
data:
  _DATASOURCE_ADDRESS: mysql:3306
  _DATASOURCE_TABLESPACE: store
  _DATASOURCE_USERNAME: root
```


mysql-deployment.yaml - mysql pods, service 

```diff
apiVersion: v1
kind: Pod
metadata:
  name: mysql
  namespace: msa
  labels:
    name: lbl-k8s-mysql
spec:
  containers:
  - name: mysql
    image: mysql:latest
    env:
+    - name: MYSQL_ROOT_PASSWORD	//secret ์ ์๋ ํค ์ฌ์ฉ
+      valueFrom:
+        secretKeyRef:
+          name: mysql-pass
+          key: password
    ports:
    - name: mysql
      containerPort: 3306
      protocol: TCP
    volumeMounts:
    - name: k8s-mysql-storage
      mountPath: /var/lib/mysql
+  volumes:				//PVC ์ฐ๊ฒฐ
+  - name: k8s-mysql-storage
+    persistentVolumeClaim:
+      claimName: "fs"

---
apiVersion: v1
kind: Service
metadata:
  labels:
    name: lbl-k8s-mysql
  name: mysql
  namespace: msa
spec:
  ports:
  - port: 3306
    protocol: TCP
    targetPort: 3306
  selector:
    name: lbl-k8s-mysql
  type: ClusterIP
```


![image](https://user-images.githubusercontent.com/23250734/191879122-4fdd9e79-6f17-420e-91c2-de088e1056de.png)

#### ํ์คํธ

order์๋น์ค์ ์ฌ์ฉ์ ๋ช๋ น์ด๋ฅผ ํตํด order๋ฅผ ์์ฑํ๊ณ  DB์ ๋ฐ์ดํฐ ์ ์ฅ๋ ๊ฒ์ ํ์ธํ๋ค.

![image](https://user-images.githubusercontent.com/23250734/191879207-43fd8ad5-7fcd-4e44-a3ec-6505cb62ed06.png)

mysql๋ฅผ ์ข๋ฃ ํ ์ฌ์์ํ๋ค.

![image](https://user-images.githubusercontent.com/23250734/191879296-6e6ed711-9f0e-436a-ad4f-b9855aab50ca.png)

![image](https://user-images.githubusercontent.com/23250734/191879422-d70fb39f-0260-4a4b-91aa-c42a38c3dc25.png)

mysql์ ์ข๋ฃ ํ ์ฌ์์ํด๋ ๋ฐ์ดํฐ๊ฐ ์ ์ง๋๋ ๊ฒ์ ํ์ธํ๋ค.

![image](https://user-images.githubusercontent.com/23250734/191879464-b9bd10d9-8d29-4582-9b4a-6b4ea9e5eab3.png)

--------------------------------------------------
## Polyglot

```
๊ฐ ๋ง์ดํฌ๋ก์๋น์ค ๋ณ ํน์ฑ์ ๋ง๋ ์ธ์ด๋ DB๋ฅผ ์ ํํด ๊ฐ๋ฐํ๋ ๊ฒ์ polyglot์ด๋ผ๊ณ  ํ๋ค.

์ด๋ฒ ํ ํ๋ก์ ํธ์์  ์๋น์ค๋ณ DB๋ฅผ ๋ค๋ฅด๊ฒ ์ฌ์ฉํด ํ์คํธํ์๋ค.
order์๋น์ค๋ mysql, dashboard์๋น์ค๋ ๊ธฐ๋ณธ ์ ๊ณต ๋ด์ฅ H2 DB๋ฅผ ์ฌ์ฉํ๊ณ , ๊ฐ ์๋น์ค ๊ฐ ํต์ ๊ณผ ๋์์ ๋ฌธ์ ๊ฐ ์๋ ๊ฒ์ ํ์ธํ๋ค.
```

#### ์ฌ์  ์ค๋น์ฌํญ

```
ํด๋ฌ์คํฐ์ mysql ๋ฐฐํฌ.
```

#### ํ์คํธ๋ฅผ ์ํ deployment์ค์  ๋ฐ ๋ฐฐํฌ.

order์๋น์ค application.yml

```diff
spring:
  profiles: docker
  jpa:
    hibernate:
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
      ddl-auto: update
    properties:
      hibernate:
        show_sql: true
        format_sql: true
        dialect: org.hibernate.dialect.MySQL57Dialect
+  datasource:
+    url: jdbc:mysql://${_DATASOURCE_ADDRESS:35.221.110.118:3306}/${_DATASOURCE_TABLESPACE:my-database}		//mysql๋ก ๊ตฌํ.
+    username: ${_DATASOURCE_USERNAME:root1}
+    password: ${_DATASOURCE_PASSWORD:secretpassword}
+    driverClassName: com.mysql.cj.jdbc.Driver
  cloud:
    stream:
      kafka:
        binder:
          brokers: my-kafka:9092
        streams:
          binder:
            configuration:
              default:
                key:
                  serde: org.apache.kafka.common.serialization.Serdes$StringSerde
                value:
                  serde: org.apache.kafka.common.serialization.Serdes$StringSerde
      bindings:
        event-in:
          group: order
          destination: teamcapstone
          contentType: application/json
        event-out:
          destination: teamcapstone
          contentType: application/json

api:
  url:
    payment: payment:8080
```

dashboard ์๋น์ค application yml

```diff
+ ๋ฐ๋ก DB ์ค์ ํ์ง ์๊ณ  ๊ธฐ๋ณธ ์ธ๋ฉ๋ชจ๋ฆฌ DB ๊ธฐ๋ฅ ์ฌ์ฉ.
spring:
  profiles: docker
  cloud:
    stream:
      kafka:
        binder:
          brokers: my-kafka:9092
        streams:
          binder:
            configuration:
              default:
                key:
                  serde: org.apache.kafka.common.serialization.Serdes$StringSerde
                value:
                  serde: org.apache.kafka.common.serialization.Serdes$StringSerde
      bindings:
        event-in:
          group: dashboard
          destination: teamcapstone
          contentType: application/json
        event-out:
          destination: teamcapstone
          contentType: application/json
```


pod ๋ฐฐํฌ.

order์๋น์ค์ deployment.yaml

```diff
apiVersion: apps/v1
kind: Deployment
metadata:
  name: order
  labels:
    app: order
spec:
  replicas: 3
  selector:
    matchLabels:
      app: order
  template:
    metadata:
      labels:
        app: order
    spec:
      containers:
        - name: order
          image: vkv6581/order:v2.1
          ports:
            - containerPort: 8080
+          env:						//ํด๋ฌ์คํฐ ๋ด๋ถ์ DB์ ๋ณด
+            - name: _DATASOURCE_ADDRESS
+              valueFrom:
+                configMapKeyRef:
+                  name: mysql-config          
+                  key: _DATASOURCE_ADDRESS
+            - name: _DATASOURCE_TABLESPACE
+              valueFrom:
+                configMapKeyRef:
+                  name: mysql-config          
+                  key: _DATASOURCE_TABLESPACE
+            - name: _DATASOURCE_USERNAME
+              valueFrom:
+                configMapKeyRef:
+                  name: mysql-config          
+                  key: _DATASOURCE_USERNAME
+            - name: _DATASOURCE_PASSWORD
+              valueFrom:
+                secretKeyRef:
+                  name: mysql-pass
+                  key: password
          resources:
              requests:
                cpu: "200m"
          readinessProbe:
            httpGet:
              path: '/actuator/health'
              port: 8080
            initialDelaySeconds: 10
            timeoutSeconds: 2
            periodSeconds: 5
            failureThreshold: 10
          livenessProbe:
            httpGet:
              path: '/actuator/health'
              port: 8080
            initialDelaySeconds: 120
            timeoutSeconds: 2
            periodSeconds: 5
            failureThreshold: 5
---
apiVersion: v1
kind: Service
metadata:
  name: order
  labels:
    app: order
spec:
  ports:
    - port: 8080
      targetPort: 8080
  selector:
    app: order
```

dashboard์๋น์ค์ deployment.yaml

```
+ //DB์ ๋ณด ์์.
apiVersion: apps/v1
kind: Deployment
metadata:
  name: dashboard
  labels:
    app: dashboard
spec:
  replicas: 1
  selector:
    matchLabels:
      app: dashboard
  template:
    metadata:
      labels:
        app: dashboard
    spec:
      containers:
        - name: dashboard
          image: vkv6581/dashboard:v1
          ports:
            - containerPort: 8080
          readinessProbe:
            httpGet:
              path: '/actuator/health'
              port: 8080
            initialDelaySeconds: 10
            timeoutSeconds: 2
            periodSeconds: 5
            failureThreshold: 10
          livenessProbe:
            httpGet:
              path: '/actuator/health'
              port: 8080
            initialDelaySeconds: 120
            timeoutSeconds: 2
            periodSeconds: 5
            failureThreshold: 5
```

์ฟ ๋ฒ๋คํฐ์ค์ ๋ฐฐํฌ

![image](https://user-images.githubusercontent.com/23250734/191895525-90482e47-d37d-412a-9c15-46a62683b6ef.png)


#### ํ์คํธ

์ฃผ๋ฌธ ์คํ

![image](https://user-images.githubusercontent.com/23250734/191895597-3d10428f-edec-4950-bcf6-ac6e5c488e01.png)

์ฃผ๋ฌธ ํ ์ฃผ๋ฌธ์ ๋ณด DB ํ์ธ.

![image](https://user-images.githubusercontent.com/23250734/191895794-0748ab9c-a95d-440e-9f32-e1f47bb47212.png)

dashboard์ ์ฃผ๋ฌธ ์ ๋ณด ์๋ ฅ๋ ๊ฒ์ ํ์ธ.

![image](https://user-images.githubusercontent.com/23250734/191895816-6cbc8202-e459-4e4d-b25d-c659bf998601.png)

์๋ก ๋ค๋ฅธ DB๋ฅผ ์ฌ์ฉํ์ง๋ง ์ด๋ฒคํธ ํธ์ถ ๋ฐ ๋์์ด ๋๋ ๊ฒ์ ํ์ธํ  ์ ์๋ค.


--- ๋
