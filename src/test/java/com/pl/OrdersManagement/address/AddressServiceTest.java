package com.pl.OrdersManagement.address;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    AddressService addressService = new AddressService(addressRepository);
    Address address = mock(Address.class);

    @Test
    public void should_return_one_item_which_is_in_db_should_exist() {
//given
        AddressService addressService = new AddressService(addressRepository);
        Address address = mock(Address.class);
//when
        addressService.add(address);
//then
        when(addressRepository.findAll()).
                thenReturn(Collections.singletonList(address));

        assertEquals(1, addressService.getAll().size());
    }

    @Test
    public void when_remove_item_then_should_return_one_item_list() {
        //given
        addressService.add(address);
        //when
        addressService.remove(address.getId());
        //then
        when(addressRepository.findAll())
                .thenReturn(Collections.emptyList());
        assertEquals(0, addressService.getAll().size());

    }


}