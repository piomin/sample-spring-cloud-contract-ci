import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'GET'
		urlPath('/persons/1')
	}
	response { 
		status OK()
		body(
			id: 1,
			firstName: 'Piotr',
			lastName: 'Minkowski',
			accountNo: '12345676870'
		)
		headers { 
			contentType(applicationJson())
		}
	}
}