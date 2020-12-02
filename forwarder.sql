SELECT ORDERS0_.FORWARDER_ID AS FORWARDE8_3_0_,
ORDERS0_.ID AS ID1_3_0_,
ORDERS0_.ID AS ID1_3_1_,
ORDERS0_.CARRIER_ID AS CARRIER_6_3_1_,
ORDERS0_.CARRIER_CURRENCY AS CARRIER_2_3_1_,
ORDERS0_.CARRIER_PRICE AS CARRIER_3_3_1_,
ORDERS0_.CUSTOMER_ID AS CUSTOMER7_3_1_, ORDERS0_.CUSTOMER_CURRENCY AS CUSTOMER4_3_1_, ORDERS0_.CUSTOMER_PRICE AS CUSTOMER5_3_1_, ORDERS0_.FORWARDER_ID AS FORWARDE8_3_1_, ORDERS0_.LOADING_PLACE_ID AS LOADING_9_3_1_, ORDERS0_.UNLOADING_PLACE_ID AS UNLOADI10_3_1_, CONTRACTOR1_.ID AS ID1_1_2_, CONTRACTOR1_.CITY AS CITY2_1_2_, CONTRACTOR1_.CONTACT_PERSON AS CONTACT_3_1_2_, CONTRACTOR1_.COUNTRY_CODE AS COUNTRY_4_1_2_, CONTRACTOR1_.NAME AS NAME5_1_2_, CONTRACTOR1_.NUMBER AS NUMBER6_1_2_, CONTRACTOR1_.PHONE_NUMBER AS PHONE_NU7_1_2_, CONTRACTOR1_.STREET AS STREET8_1_2_, CONTRACTOR1_.VAT_ID AS VAT_ID9_1_2_, CONTRACTOR1_.ZIP AS ZIP10_1_2_, CONTRACTOR2_.ID AS ID1_1_3_, CONTRACTOR2_.CITY AS CITY2_1_3_, CONTRACTOR2_.CONTACT_PERSON AS CONTACT_3_1_3_, CONTRACTOR2_.COUNTRY_CODE AS COUNTRY_4_1_3_, CONTRACTOR2_.NAME AS NAME5_1_3_, CONTRACTOR2_.NUMBER AS NUMBER6_1_3_, CONTRACTOR2_.PHONE_NUMBER AS PHONE_NU7_1_3_, CONTRACTOR2_.STREET AS STREET8_1_3_, CONTRACTOR2_.VAT_ID AS VAT_ID9_1_3_, CONTRACTOR2_.ZIP AS ZIP10_1_3_, ADDRESS3_.ID AS ID1_0_4_, ADDRESS3_.CITY AS CITY2_0_4_, ADDRESS3_.COUNTRY_CODE AS COUNTRY_3_0_4_, ADDRESS3_.NAME AS NAME4_0_4_, ADDRESS3_.NUMBER AS NUMBER5_0_4_, ADDRESS3_.STREET AS STREET6_0_4_, ADDRESS3_.ZIP AS ZIP7_0_4_, ADDRESS4_.ID AS ID1_0_5_, ADDRESS4_.CITY AS CITY2_0_5_, ADDRESS4_.COUNTRY_CODE AS COUNTRY_3_0_5_, ADDRESS4_.NAME AS NAME4_0_5_, ADDRESS4_.NUMBER AS NUMBER5_0_5_, ADDRESS4_.STREET AS STREET6_0_5_, ADDRESS4_.ZIP AS ZIP7_0_5_ FROM ORDER[*] ORDERS0_ LEFT OUTER JOIN CONTRACTOR CONTRACTOR1_ ON ORDERS0_.CARRIER_ID=CONTRACTOR1_.ID LEFT OUTER JOIN CONTRACTOR CONTRACTOR2_ ON ORDERS0_.CUSTOMER_ID=CONTRACTOR2_.ID LEFT OUTER JOIN ADDRESS ADDRESS3_ ON ORDERS0_.LOADING_PLACE_ID=ADDRESS3_.ID LEFT OUTER JOIN ADDRESS ADDRESS4_ ON ORDERS0_.UNLOADING_PLACE_ID=ADDRESS4_.ID WHERE ORDERS0_.FORWARDER_ID=?"; expected "identifier"; SQL statement:
select orders0_.forwarder_id as forwarde8_3_0_, orders0_.id as id1_3_0_, orders0_.id as id1_3_1_, orders0_.carrier_id as carrier_6_3_1_, orders0_.carrier_currency as carrier_2_3_1_, orders0_.carrier_price as carrier_3_3_1_, orders0_.customer_id as customer7_3_1_, orders0_.customer_currency as customer4_3_1_, orders0_.customer_price as customer5_3_1_, orders0_.forwarder_id as forwarde8_3_1_, orders0_.loading_place_id as loading_9_3_1_, orders0_.unloading_place_id as unloadi10_3_1_, contractor1_.id as id1_1_2_, contractor1_.city as city2_1_2_, contractor1_.contact_person as contact_3_1_2_, contractor1_.country_code as country_4_1_2_, contractor1_.name as name5_1_2_, contractor1_.number as number6_1_2_, contractor1_.phone_number as phone_nu7_1_2_, contractor1_.street as street8_1_2_, contractor1_.vat_id as vat_id9_1_2_, contractor1_.zip as zip10_1_2_, contractor2_.id as id1_1_3_, contractor2_.city as city2_1_3_, contractor2_.contact_person as contact_3_1_3_, contractor2_.country_code as country_4_1_3_, contractor2_.name as name5_1_3_, contractor2_.number as number6_1_3_, contractor2_.phone_number as phone_nu7_1_3_, contractor2_.street as street8_1_3_, contractor2_.vat_id as vat_id9_1_3_, contractor2_.zip as zip10_1_3_, address3_.id as id1_0_4_, address3_.city as city2_0_4_, address3_.country_code as country_3_0_4_, address3_.name as name4_0_4_, address3_.number as number5_0_4_, address3_.street as street6_0_4_, address3_.zip as zip7_0_4_, address4_.id as id1_0_5_, address4_.city as city2_0_5_, address4_.country_code as country_3_0_5_, address4_.name as name4_0_5_, address4_.number as number5_0_5_, address4_.street as street6_0_5_, address4_.zip as zip7_0_5_ from order orders0_ left outer join contractor contractor1_ on orders0_.carrier_id=contractor1_.id left outer join contractor contractor2_ on orders0_.customer_id=contractor2_.id left outer join address address3_ on orders0_.loading_place_id=address3_.id left outer join address address4_ on orders0_.unloading_place_id=address4_.id where orders0_.forwarder_id=? [42001-200]