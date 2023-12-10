# SCM(Supply Chain Management) | 공급망 관리
<br/>
개발자가 되기 전 근무했던 회사의 SCM시스템을 떠올리며 만들었습니다.

개발자가 아닌 클라이언트 입장에서 조작만 했던 프로그램이였기에,

각 기능들의 구조는 어떻게 되어있을까를 추측하며 만들었습니다.

벤더사에 따른 상품코드 등록 및 발주를 진행하고, 발주가 진행된 주문건들의 배송,매출정산까지의 과정을 구현했습니다.

## [ERD](https://www.erdcloud.com/d/yZ24nJ6Jv2iX64RMH)
![scm-project](https://github.com/lsk920110/scm-project-public/assets/97416341/c2c1c2e2-b9ff-4e55-a34a-c7650439eadf)


## [기능명세서](https://spot-yumberry-23f.notion.site/1939034b339c4e81b5ec057d01e1b464?pvs=4)


## 기술스택
 
- Framework
  - SpringBoot
  - Version : 3.0.6
- Build
  - Gradle
- JDK
  - Version : 17
- Libraries
  - thymeleaf
  - jquery
  - mybatis
- DB
  - MySQL 5.7.38
- Tools
  - Intellij
  - DBeaver
 
 ## 프로젝트 구조
 ![image](https://github.com/lsk920110/scm-project-public/assets/97416341/0c15adff-8d09-4a72-ab5d-60304783c6d9)
```
각 도메인별로 package를 생성하고, 도메인 내부에 controller,service,mapper,vo의 Package를 생성했습니다.
```
![image](https://github.com/lsk920110/scm-project-public/assets/97416341/8bb883b2-b193-4706-8a15-e1d0c23bc538)
```
common폴더에는
config : configuration관련 폴더
constant : ErrorCode 및 각종 Constant파일
controller : 공통적인 메서드를 만들어두고 모든 controller에 상속시킬 BaseController
exception : 에러처리를 담당할 GlobalExceptionHandler
interceptor : 현재 로그인정보를 세션에서 확인하여 pass or redirect 처리하는 requestInterceptor
util : 각종 유틸메서드
vo : 공통적으로 사용될 VO
```




##핵심기능
- 이 프로젝트의 핵심기능인 발주과정입니다.

![image](https://github.com/lsk920110/scm-project-public/assets/97416341/38f74ac5-7150-40ae-9879-82de572342e2)

![image](https://github.com/lsk920110/scm-project-public/assets/97416341/3d6e62f6-73be-40ed-ab6d-af45a8962171)


```
거래선,판매번호,고객정보,상품코드를 입력하고, 전표생성을 진행합니다.
주문생성시 전표생성 이후 주문까지 생성을 진행합니다.
```

![image](https://github.com/lsk920110/scm-project-public/assets/97416341/e741ec00-a2f9-4163-8a3c-4ea615893686)

```
전표만 생성한 경우 미생성건으로 생성됩니다.
해당 전표를 checkbox 클릭하여 주문생성을 클릭하면
```
![image](https://github.com/lsk920110/scm-project-public/assets/97416341/f3b6e44c-fe52-41ff-87bb-e9a5d645c97c)
```
주문번호가 부여됩니다.
```



