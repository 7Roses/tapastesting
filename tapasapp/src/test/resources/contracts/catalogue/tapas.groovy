import org.springframework.cloud.contract.spec.Contract
/*
TODO step3: create the contract (producer side)
    - Check out the producer’s repository
    - Add a contract using the Spring Cloud Contract Groovy DSL based on how the consumer expects the producer to behave
    - This file should be located in src/test/resources/contracts/ for the spring-cloud-contract-plugin to find it
*/
Contract.make{
    description "should return a list of all catalogue"

    request{
        method GET()
        url "/tapas"
    }

    response{
        status 200
        headers {
            header('Content-Type': value(
                    producer(regex('application/json.*')),
                    consumer('application/json')
            ))
        }
        body (
            [
                [
                        id: 0,
                        name: "All i oli",
                        price: 1.5
                ],
                [
                        id: 1,
                        name: "Banderillas",
                        price: 3
                ]
             ]
        )
    }
}