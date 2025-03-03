import { useMutation } from '@apollo/client';
import { LOGIN } from '../queries';

const useLogin = () => {
  const [login, result] = useMutation(LOGIN);

  const handleLogin = async (username, password) => {
    try {
      await login({ variables: { username, password } });
    } catch (error) {
      console.error(error);
    }
  };

  return { handleLogin, result };
};

export default useLogin;