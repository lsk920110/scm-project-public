
CREATE DATABASE `scmProject` /*!40100 DEFAULT CHARACTER SET utf8 */;


-- scmProject.callHistory definition

CREATE TABLE `callHistory` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `orderId` int(11) NOT NULL,
                               `memo` text NOT NULL,
                               `regDt` datetime DEFAULT NULL,
                               `state` char(1) DEFAULT '1',
                               `regMemberId` int(11) NOT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- scmProject.category definition

CREATE TABLE `category` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `productCategory` varchar(32) DEFAULT NULL,
                            `state` char(1) DEFAULT NULL,
                            `regMemberId` int(11) DEFAULT NULL,
                            `regDt` datetime DEFAULT CURRENT_TIMESTAMP,
                            `updMemberId` int(11) DEFAULT NULL,
                            `updDt` datetime DEFAULT CURRENT_TIMESTAMP,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- scmProject.department definition

CREATE TABLE `department` (
                              `id` varchar(5) NOT NULL,
                              `department` varchar(16) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- scmProject.incomingStock definition

CREATE TABLE `incomingStock` (
                                 `txId` int(11) NOT NULL AUTO_INCREMENT,
                                 `modelId` int(11) DEFAULT NULL,
                                 `quantity` int(11) DEFAULT NULL,
                                 `txReason` char(1) DEFAULT NULL,
                                 `txDt` datetime DEFAULT NULL,
                                 PRIMARY KEY (`txId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- scmProject.`member` definition

CREATE TABLE `member` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `departmentId` varchar(10) DEFAULT NULL,
                          `email` varchar(128) NOT NULL,
                          `password` varchar(256) DEFAULT NULL,
                          `birth` varchar(16) DEFAULT NULL,
                          `state` varchar(10) DEFAULT NULL,
                          `role` varchar(10) DEFAULT NULL,
                          `name` varchar(10) DEFAULT NULL,
                          `authToken` varchar(128) DEFAULT NULL,
                          `authDt` datetime DEFAULT NULL,
                          `regDt` datetime DEFAULT CURRENT_TIMESTAMP,
                          `regMember` int(11) DEFAULT NULL,
                          `updMember` int(11) DEFAULT NULL,
                          `updDt` datetime DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100016 DEFAULT CHARSET=utf8;


-- scmProject.menubar definition

CREATE TABLE `menubar` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `menuTitle` varchar(16) DEFAULT NULL,
                           `link` varchar(128) DEFAULT NULL,
                           `position` char(1) DEFAULT NULL,
                           `state` char(1) DEFAULT NULL,
                           `orderSeq` int(11) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;


-- scmProject.model definition

CREATE TABLE `model` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `categoryId` int(11) DEFAULT NULL,
                         `regMemberId` int(11) DEFAULT NULL,
                         `regDt` datetime DEFAULT NULL,
                         `updMemberId` int(11) DEFAULT NULL,
                         `updDt` datetime DEFAULT NULL,
                         `modelCord` varchar(16) DEFAULT NULL,
                         `stock` int(11) DEFAULT NULL,
                         `state` char(1) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


-- scmProject.outgoingStock definition

CREATE TABLE `outgoingStock` (
                                 `txId` int(11) NOT NULL AUTO_INCREMENT,
                                 `modelId` int(11) DEFAULT NULL,
                                 `quantity` int(11) DEFAULT NULL,
                                 `txReason` char(1) DEFAULT NULL,
                                 `txDt` datetime DEFAULT NULL,
                                 `orderId` int(11) DEFAULT NULL,
                                 PRIMARY KEY (`txId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- scmProject.product definition

CREATE TABLE `product` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `productCategory` varchar(32) DEFAULT NULL,
                           `state` char(1) DEFAULT NULL,
                           `regMemberId` int(11) DEFAULT NULL,
                           `regDt` datetime DEFAULT CURRENT_TIMESTAMP,
                           `updMemberId` int(11) DEFAULT NULL,
                           `updDt` datetime DEFAULT CURRENT_TIMESTAMP,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- scmProject.productCategory_v2 definition

CREATE TABLE `productCategory_v2` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `productCategory` varchar(32) DEFAULT NULL,
                                      `state` char(1) DEFAULT NULL,
                                      `regMemberId` int(11) DEFAULT NULL,
                                      `regDt` datetime DEFAULT CURRENT_TIMESTAMP,
                                      `updMemberId` int(11) DEFAULT NULL,
                                      `updDt` datetime DEFAULT CURRENT_TIMESTAMP,
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


-- scmProject.productCord_v2 definition

CREATE TABLE `productCord_v2` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `vendorId` int(11) DEFAULT NULL,
                                  `modelId` int(11) DEFAULT NULL,
                                  `productCord` varchar(64) DEFAULT NULL,
                                  `supplyPrice` bigint(20) DEFAULT NULL,
                                  `supplyPriceVat` bigint(20) DEFAULT NULL,
                                  `regMemberId` int(11) DEFAULT NULL,
                                  `regDt` datetime DEFAULT NULL,
                                  `updMemberId` int(11) DEFAULT NULL,
                                  `updDt` datetime DEFAULT NULL,
                                  `state` char(1) DEFAULT NULL,
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- scmProject.productStatus definition

CREATE TABLE `productStatus` (
                                 `id` int(11) NOT NULL,
                                 `productStatus` varchar(10) DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- scmProject.salesInfo definition

CREATE TABLE `salesInfo` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `deliveryId` int(11) DEFAULT NULL,
                             `orderId` int(11) DEFAULT NULL,
                             `statementId` int(11) DEFAULT NULL,
                             `tc` varchar(10) DEFAULT NULL,
                             `vendorId` int(11) DEFAULT NULL,
                             `vendorName` varchar(16) DEFAULT NULL,
                             `salesNo` varchar(64) DEFAULT NULL,
                             `orderRegDt` date DEFAULT NULL,
                             `deliveryCompletionDt` date DEFAULT NULL,
                             `salesRegDt` date DEFAULT NULL,
                             `customerName` varchar(16) DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `salesInfoUniqueKeys` (`deliveryId`,`orderId`,`statementId`)
) ENGINE=InnoDB AUTO_INCREMENT=1028 DEFAULT CHARSET=utf8;


-- scmProject.statementProductCord definition

CREATE TABLE `statementProductCord` (
                                        `id` int(11) NOT NULL AUTO_INCREMENT,
                                        `productCord` varchar(64) NOT NULL,
                                        `statementId` int(11) NOT NULL,
                                        `orderSeq` int(11) DEFAULT NULL,
                                        `orderQuantity` int(11) DEFAULT NULL,
                                        `state` char(1) DEFAULT NULL,
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;


-- scmProject.transportCenterInfo definition

CREATE TABLE `transportCenterInfo` (
                                       `tc` varchar(10) NOT NULL,
                                       `deliveryArea` varchar(64) DEFAULT NULL,
                                       `telephone` varchar(64) DEFAULT NULL,
                                       `state` char(1) DEFAULT NULL,
                                       PRIMARY KEY (`tc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- scmProject.deliveryInstallationStaff definition

CREATE TABLE `deliveryInstallationStaff` (
                                             `id` int(11) NOT NULL AUTO_INCREMENT,
                                             `tc` varchar(10) NOT NULL,
                                             `staffName` varchar(10) DEFAULT NULL,
                                             `staffPhoneNum` varchar(64) DEFAULT NULL,
                                             `state` char(1) DEFAULT NULL,
                                             `staff_password` varchar(64) DEFAULT NULL,
                                             `password` varchar(64) DEFAULT NULL,
                                             PRIMARY KEY (`id`),
                                             KEY `tc` (`tc`),
                                             CONSTRAINT `deliveryInstallationStaff_ibfk_1` FOREIGN KEY (`tc`) REFERENCES `transportCenterInfo` (`tc`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- scmProject.productCategory definition

CREATE TABLE `productCategory` (
                                   `id` int(11) NOT NULL AUTO_INCREMENT,
                                   `productCategory` varchar(64) DEFAULT NULL,
                                   `memberId` int(11) DEFAULT NULL,
                                   `state` char(1) DEFAULT '1',
                                   `regDt` datetime DEFAULT CURRENT_TIMESTAMP,
                                   PRIMARY KEY (`id`),
                                   KEY `memberId` (`memberId`),
                                   CONSTRAINT `productCategory_ibfk_1` FOREIGN KEY (`memberId`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;


-- scmProject.productModel definition

CREATE TABLE `productModel` (
                                `id` int(10) NOT NULL AUTO_INCREMENT,
                                `productCategoryId` int(11) NOT NULL,
                                `memberId` int(11) NOT NULL,
                                `modelCord` varchar(64) DEFAULT NULL,
                                `stock` int(11) DEFAULT NULL,
                                `productStatusId` char(1) DEFAULT NULL,
                                `regDt` datetime DEFAULT CURRENT_TIMESTAMP,
                                PRIMARY KEY (`id`),
                                KEY `memberId` (`memberId`),
                                KEY `productCategoryId` (`productCategoryId`),
                                CONSTRAINT `productModel_ibfk_1` FOREIGN KEY (`memberId`) REFERENCES `member` (`id`),
                                CONSTRAINT `productModel_ibfk_2` FOREIGN KEY (`productCategoryId`) REFERENCES `productCategory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;


-- scmProject.salesProductCord definition

CREATE TABLE `salesProductCord` (
                                    `id` int(11) NOT NULL AUTO_INCREMENT,
                                    `salesId` int(11) NOT NULL,
                                    `productCord` varchar(32) DEFAULT NULL,
                                    `modelCord` varchar(32) DEFAULT NULL,
                                    `orderQuantity` int(11) DEFAULT NULL,
                                    `supplyPrice` bigint(20) DEFAULT NULL,
                                    `supplyPriceVat` bigint(20) DEFAULT NULL,
                                    `orderSeq` int(11) DEFAULT NULL,
                                    `statementId` int(11) DEFAULT NULL,
                                    PRIMARY KEY (`id`),
                                    KEY `salesId` (`salesId`),
                                    CONSTRAINT `salesProductCord_ibfk_1` FOREIGN KEY (`salesId`) REFERENCES `salesInfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;


-- scmProject.vendorInfo definition

CREATE TABLE `vendorInfo` (
                              `id` int(7) NOT NULL AUTO_INCREMENT,
                              `vendorName` varchar(255) DEFAULT NULL,
                              `contractStartDt` datetime DEFAULT NULL,
                              `contractEndDt` datetime DEFAULT NULL,
                              `state` varchar(255) DEFAULT NULL,
                              `regMemberId` int(11) NOT NULL,
                              `regDt` datetime DEFAULT NULL,
                              `businessRegNum` varchar(32) DEFAULT NULL,
                              `updMemberId` int(11) DEFAULT NULL,
                              `updDt` datetime DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `regMemberId` (`regMemberId`),
                              CONSTRAINT `vendorInfo_ibfk_1` FOREIGN KEY (`regMemberId`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000008 DEFAULT CHARSET=utf8;


-- scmProject.productCord definition

CREATE TABLE `productCord` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `vendorId` int(11) NOT NULL,
                               `productModelId` int(11) NOT NULL,
                               `productCord` varchar(256) DEFAULT NULL,
                               `supplyPrice` bigint(20) DEFAULT NULL,
                               `supplyPriceVat` bigint(20) DEFAULT NULL,
                               `regDt` datetime DEFAULT NULL,
                               `state` char(1) DEFAULT NULL,
                               `regMemberId` int(6) NOT NULL,
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `productCord` (`productCord`),
                               KEY `regMemberId` (`regMemberId`),
                               KEY `vendorId` (`vendorId`),
                               KEY `productModelId` (`productModelId`),
                               CONSTRAINT `productCord_ibfk_1` FOREIGN KEY (`regMemberId`) REFERENCES `member` (`id`),
                               CONSTRAINT `productCord_ibfk_2` FOREIGN KEY (`vendorId`) REFERENCES `vendorInfo` (`id`),
                               CONSTRAINT `productCord_ibfk_3` FOREIGN KEY (`productModelId`) REFERENCES `productModel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- scmProject.`statement` definition

CREATE TABLE `statement` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `salesNo` varchar(32) DEFAULT NULL,
                             `customerName` varchar(16) DEFAULT NULL,
                             `customerPhoneNumber` varchar(32) DEFAULT NULL,
                             `customerAddressFirst` varchar(16) DEFAULT NULL,
                             `customerAddressSecond` varchar(16) DEFAULT NULL,
                             `customerAddressThird` varchar(16) DEFAULT NULL,
                             `customerAddressDetail` varchar(256) DEFAULT NULL,
                             `deliveryReqDt` date DEFAULT NULL,
                             `remarks` varchar(256) DEFAULT NULL,
                             `state` char(1) DEFAULT NULL,
                             `vendorId` int(11) NOT NULL,
                             `regMemberId` int(6) NOT NULL,
                             `regDt` datetime DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `vendorId` (`vendorId`),
                             KEY `regMemberId` (`regMemberId`),
                             CONSTRAINT `statement_ibfk_1` FOREIGN KEY (`vendorId`) REFERENCES `vendorInfo` (`id`),
                             CONSTRAINT `statement_ibfk_2` FOREIGN KEY (`regMemberId`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;


-- scmProject.orderInfo definition

CREATE TABLE `orderInfo` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `orderState` char(1) DEFAULT NULL,
                             `regDt` datetime DEFAULT NULL,
                             `state` char(1) DEFAULT NULL,
                             `statementId` int(11) NOT NULL,
                             PRIMARY KEY (`id`),
                             KEY `statementId` (`statementId`),
                             CONSTRAINT `orderInfo_ibfk_1` FOREIGN KEY (`statementId`) REFERENCES `statement` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000032 DEFAULT CHARSET=utf8;


-- scmProject.deliveryInfo definition

CREATE TABLE `deliveryInfo` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `orderId` int(11) NOT NULL,
                                `tc` varchar(10) NOT NULL,
                                `expectedDeliveryDt` date DEFAULT NULL,
                                `deliveryCompletionDt` date DEFAULT NULL,
                                `state` char(1) DEFAULT '1',
                                `deliveryStaffId` int(11) NOT NULL,
                                PRIMARY KEY (`id`),
                                KEY `orderId` (`orderId`),
                                KEY `tc` (`tc`),
                                KEY `deliveryStaffId` (`deliveryStaffId`),
                                CONSTRAINT `deliveryInfo_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orderInfo` (`id`),
                                CONSTRAINT `deliveryInfo_ibfk_2` FOREIGN KEY (`tc`) REFERENCES `transportCenterInfo` (`tc`),
                                CONSTRAINT `deliveryInfo_ibfk_3` FOREIGN KEY (`deliveryStaffId`) REFERENCES `deliveryInstallationStaff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;