package br.com.overseasdev.hrpayroll.services;

import br.com.overseasdev.hrpayroll.entities.Payment;
import br.com.overseasdev.hrpayroll.entities.Worker;
import br.com.overseasdev.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
