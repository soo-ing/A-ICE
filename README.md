# 프로젝트 설명

IoT 기반의 블랙아이스 탐지 시스템

# 기술 스택

<img src="https://img.shields.io/badge/C-00D8FF?style=flat-square&logo=C&logoColor=white" /> <img src="https://img.shields.io/badge/Java-5F00FF?style=flat-square&logo=Java&logoColor=white" /> <img src="https://img.shields.io/badge/Python-A566FF?style=flat-square&logo=Python&logoColor=white" />

<img src="https://img.shields.io/badge/Android-9FC93C?style=flat-square&logo=Android&logoColor=white" /> <img src="https://img.shields.io/badge/Arduino-3DB7CC?style=flat-square&logo=Arduino&logoColor=white" /> <img src="https://img.shields.io/badge/Raspberry Pi-F361A6?style=flat-square&logo=Raspberry Pi&logoColor=white" />

<img src="https://img.shields.io/badge/MySQL-3DB7CC?style=flat-square&logo=MySQL&logoColor=white" /> <img src="https://img.shields.io/badge/PHP-99004C?style=flat-square&logo=PHP&logoColor=white" /> <img src="https://img.shields.io/badge/TensorFlow-E5D85C?style=flat-square&logo=TensorFlow&logoColor=white" />

# 프로그램 기능

- 블랙 아이스 위험 상황 감지를 위한 Deep-Learning 기반 CCTV 환경 조성
- 각종 센서를 통한 블랙 아이스 조성 환경 검출
- 운전자에게 실시간으로 알릴 수 있는 어플 개발
- GPS를 통한 사용성 제공

# 상세 기술

- Teachable Machine을 이용하여 Deep-Learning 환경 구성
- Raspberry Pi의 카메라 센서를 이용하여 도로를 찍어 기존에 학습된 도로와 비교
- Arduino의 빗물감지센서와 온습도센서를 상호작용하여 PHP에 기술한 메커니즘을 적용
- 모든 상호작용을 고려하여 블랙 아이스의 위험도로라고 판명이 되면 해당 App에 실시간으로 도로의 정보를 표시하고 알림

# 시스템 구성

## 구성도 1

![image](https://user-images.githubusercontent.com/84956281/141677324-177fbabe-65af-4185-b2fe-5448af0402a3.png)

## 구성도 2

![image](https://user-images.githubusercontent.com/84956281/141677308-2445815b-2438-4cd7-ad31-a0eb6d53a2bb.png)

# 상세 설명

## Deep-Learning

> 3가지의 상황에 맞는 도로 사진 자동으로 수집하고 학습

![image](https://user-images.githubusercontent.com/84956281/141677619-3d131d27-33d6-4945-a8ee-c829a0c385da.png)

> 학습된 도로의 모습

![image](https://user-images.githubusercontent.com/84956281/141677678-80584569-5e64-4322-bb4e-c7ac8a5b7237.png)

> Android

![image](https://user-images.githubusercontent.com/84956281/141678386-48788134-874f-422c-9e70-d5288d70a002.png)

# 함께한 팀원들

- 차수빈 (팀장)
- 권오제 (팀원)
- 천세빈 (팀원)
