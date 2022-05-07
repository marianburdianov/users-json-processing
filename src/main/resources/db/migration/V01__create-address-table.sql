drop table if exists address;
create table if not exists address
(
    address_id bigint generated by default as identity
        (increment 1 start 1 minvalue 1 maxvalue 9223372036854775807 cache 1)
        primary key,
    user_id    bigint,
    street     varchar(30),
    suite      varchar(20) default null,
    city       varchar(30) default null,
    zipcode    varchar(20) default null,
    constraint fk_users
        foreign key (user_id)
            references public.users(user_id)
);

insert into address(user_id, street, suite, city, zipcode)
values (1, 'Kulas Light', 'Apt. 556', 'Gwenborough', '924395-543');
insert into address(user_id, street, suite, city, zipcode)
values (2, 'Victor Plains', 'Suite 879', 'Wisokyburgh', '924395-543');

select *
from address;
