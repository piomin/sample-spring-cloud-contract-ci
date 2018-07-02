import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'GET'
		urlPath('/persons/1')
	}
	response { 
		status OK()
		body([
			id: 1,
			firstName: 'Piotr',
			lastName: 'Minkowski',
			gender: $(regex('(MALE|FEMALE)')),
			contact: ([ 
				email: $(regex(email())),
				phoneNo: $(regex('[0-9]{9}$')) 
			])
		])
		headers { 
			contentType(applicationJson())
		}
	}
}