import org.springframework.cloud.contract.spec.Contract

Contract.make{
    description "create new basket"

    request{
        method POST()
        url "/basket"
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
                //$(anyNumber()) //doesn't match pattern "-?d*(.d+)?"
                //$(regex(number())) //doesn't match pattern "-?d*(.d+)?"

                $(regex('[0-9]*'))
        )
    }
}